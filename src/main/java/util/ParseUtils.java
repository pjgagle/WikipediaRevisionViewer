package util;


import Domains.Editor;
import Domains.Redirect;
import Domains.WikipediaPage;
import Exceptions.NoWikiPageFoundException;
import Exceptions.ParameterIsNotJsonStringException;
import com.google.gson.*;

import java.util.Map;

public class ParseUtils {


    public static WikipediaPage ParseJsonToObjects(String jsonString) throws ParameterIsNotJsonStringException, NoWikiPageFoundException, NoWikiPageFoundException {
        if (jsonString.charAt(0) != '{') {
            throw new ParameterIsNotJsonStringException();
        }

        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(jsonString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject query = rootObject.getAsJsonObject("query");
        JsonObject pages = query.getAsJsonObject("pages");

        int length = pages.keySet().toString().length();
        String pageIdName = pages.keySet().toString().substring(1, length-1);

        if (pageIdName.contentEquals("-1")) {
            throw new NoWikiPageFoundException();
        }

        JsonObject pageIdObj = pages.getAsJsonObject(pageIdName);
        var pageId = pageIdObj.getAsJsonPrimitive("pageid").getAsInt();
        var pageTitle = pageIdObj.getAsJsonPrimitive("title").getAsString();
        JsonArray revisions = null;

        for (Map.Entry<String, JsonElement> edit : pages.entrySet()) {
            JsonObject editObject = edit.getValue().getAsJsonObject();
            revisions = editObject.getAsJsonArray("revisions");
            String title = editObject.getAsJsonPrimitive("title").toString();
        }

        String revisionsString = revisions.toString();
        Gson newGson = new Gson();
        Editor[] editArr = newGson.fromJson(revisionsString, Editor[].class);

        if (query.keySet().contains("redirects")) {
            JsonArray redirects = query.getAsJsonArray("redirects");
            JsonObject redirectObj = redirects.get(0).getAsJsonObject();
            Gson gson = new Gson();
            Redirect redirect = gson.fromJson(redirectObj, Redirect.class);
            return new WikipediaPage(pageTitle, pageId, editArr, redirect);
        }
        return new WikipediaPage(pageTitle, pageId, editArr);
    }


}
