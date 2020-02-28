package util;

import Domains.Editor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisUtilsTest {

    @Test
    void mostFrequentEdit() {
        Editor[] edits = new Editor[2];
        edits[0].setUser("bobbie");
        edits[0].setTimestamp("2012");
        edits[1].setUser("bill");
        edits[2].setTimestamp("2020");
        Editor freqEdit = AnalysisUtils.mostFrequentEdit(edits);
        assertNotNull(freqEdit);
    }
}