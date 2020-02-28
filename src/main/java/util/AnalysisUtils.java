package util;

import Domains.Editor;
import Exceptions.NoWikiPageFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnalysisUtils {
    public static void AnalyzeEdits(Editor[] editors) throws NoWikiPageFoundException {

    }
    public static Editor mostFrequentEdit(Editor[] editors) {
        HashMap<Editor, Integer> editorsCountMap = new HashMap<>();
        for (Editor edit : editors){
            if (editorsCountMap.containsKey(edit)){
                editorsCountMap.put(edit, editorsCountMap.get(edit) + 1);
            }
            else {
                editorsCountMap.put(edit, 1);
            }

        }
        Editor elem = null;
        int freq = 1;

        Set<Map.Entry<Editor, Integer>> entrySet = editorsCountMap.entrySet();
        for (Map.Entry<Editor, Integer> entry : entrySet) {
            if (entry.getValue() > freq){
                elem = entry.getKey();
                freq = entry.getValue();
            }
        }
        return elem;
    }
}
