package util;


import Domains.Editor;
import Exceptions.ParameterIsNotJsonStringException;
import com.google.gson.*;

import java.util.Map;

public class ParseUtils {
    public static JsonArray ParseToJsonArray(String jsonString) throws ParameterIsNotJsonStringException{
        if(jsonString.charAt(0) != '{') {
            throw new ParameterIsNotJsonStringException();
        }
        JsonParser jsonParser = new JsonParser();
        JsonElement rootElem = jsonParser.parse(jsonString);
        JsonObject rootObj = rootElem.getAsJsonObject();
        JsonObject pages = rootObj.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revision = null;

        for (Map.Entry<String, JsonElement> edit : pages.entrySet()) {
            JsonObject editObj = edit.getValue().getAsJsonObject();
            revision = editObj.getAsJsonArray("revisions");
            String title = editObj.getAsJsonPrimitive("title").toString();
            System.out.println("Page Title: " + title);
        }
        return revision;

    }
    public static Editor[] ParseArrayToObjs(String jsonString){
        Gson gson = new Gson();
        Editor[] editArr = gson.fromJson(jsonString, Editor[].class);
        return editArr;
    }

}
