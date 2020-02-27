package util;

import Domains.Editor;
import Domains.Redirect;
import Domains.WikipediaPage;
import Exceptions.ParameterIsNotJsonStringException;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {
    public static WikipediaPage parseJsonToWikipediaPageDirect(String jsonString) throws ParameterIsNotJsonStringException{
        if (!jsonString.startsWith("{")) {
            throw new ParameterIsNotJsonStringException();
        }
        Gson temporaryGson = new Gson();
        return temporaryGson.fromJson(jsonString, WikipediaPage.class);
    }
    public static WikipediaPage parseJsonToWikipediaPageManual(String jsonString) throws ParameterIsNotJsonStringException{
        JsonParser jsonParser = new JsonParser();
        JsonElement rootElem = jsonParser.parse(jsonString);
        JsonObject rootObj = rootElem.getAsJsonObject();
        JsonObject queryObj = rootObj.getAsJsonObject("query");
        JsonObject pageObj = queryObj.getAsJsonObject("pages");
        int length = pageObj.keySet().toString().length();
        String pgIdObjName = pageObj.keySet().toString().substring(1, length - 1);
        JsonObject pgIdObj = pageObj.getAsJsonObject(pgIdObjName);
        var pgId = pgIdObj.getAsJsonPrimitive("pageid").getAsInt();
        var pgTitle = pgIdObj.getAsJsonPrimitive("title").getAsString();
        JsonArray revisionsObj = pgIdObj.getAsJsonArray("revisions");

        List<Editor> pgEditors = new ArrayList<>();
        for (int i = 0; i < revisionsObj.size(); i++){
            JsonObject obj = revisionsObj.get(i).getAsJsonObject();
            Gson temporaryGson = new Gson();
            Editor editor = temporaryGson.fromJson(obj, Editor.class);
            editor.setNumberEdits(1);
            pgEditors.add(editor);
            for (int j = 0; j < pgEditors.size() - 1; j++){
                if (pgEditors.get(j).getUser().contentEquals(editor.getUser())) {
                    pgEditors.get(j).setNumberEdits(pgEditors.get(j).getNumberEdits() + 1);
                }
            }
        }
        if(queryObj.keySet().contains("redirects")){
            JsonArray redirectsArray = queryObj.getAsJsonArray("redirects");
            JsonObject redirectsObj = redirectsArray.get(0).getAsJsonObject();
            Gson temporaryGson = new Gson();
            Redirect pgRedirect = temporaryGson.fromJson(redirectsObj, Redirect.class);
            return new WikipediaPage(pgTitle, pgId, pgEditors, pgRedirect);
        }
        return new WikipediaPage(pgTitle, pgId, pgEditors);

    }
}
