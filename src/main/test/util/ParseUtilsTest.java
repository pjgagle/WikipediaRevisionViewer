package util;

import Domains.Editor;
import Exceptions.ParameterIsNotJsonStringException;
import com.google.gson.JsonArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseUtilsTest {
    @Test
    void parserToJsonArraySuccessful() throws ParameterIsNotJsonStringException {
        var samples = "{\"continue\":{\"rvcontinue\":\"20200208164736|939771163\",\"continue\":\"||\"},\"query\":" +
                "{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":" +
                "\"InternetArchiveBot\",\"timestamp\":\"2020-02-24T17:26:22Z\"},{\"user\":\"Yunshui\",\"timestamp\":" +
                "\"2020-02-09T12:48:23Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:49:19Z\"},"
                + "{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:48:49Z\"}]}}}}";
        var results = ParseUtils.ParseToJsonArray(samples);
        assertNotNull(results);

    }

    /*@Test
    void parseArrayToObjSuccess() throws ParameterIsNotJsonStringException {
        var samples = "{\"continue\":{\"rvcontinue\":\"20200208164736|939771163\",\"continue\":\"||\"},\"query\"" +
                ":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\"" +
                ":\"InternetArchiveBot\",\"timestamp\":\"2020-02-24T17:26:22Z\"},{\"user\":\"Yunshui\",\"timestamp\"" +
                ":\"2020-02-09T12:48:23Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:49:19Z\"},"
                + "{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:48:49Z\"}]}}}}";
        JsonArray results = ParseUtils.ParseToJsonArray(samples);
        Editor[] editors = ParseUtils.ParseArrayToObjs(results);
        assertNotNull(editors);
    }*/
}