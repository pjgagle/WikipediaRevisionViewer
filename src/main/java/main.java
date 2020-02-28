import Domains.Editor;
import Exceptions.NetworkConnectionFailException;
import Exceptions.ParameterIsNotJsonStringException;
import util.AnalysisUtils;
import util.GetterUtils;
import util.ParseUtils;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, ParameterIsNotJsonStringException, NetworkConnectionFailException {
        Scanner console = new Scanner(System.in);
            System.out.println("Wikipedia Revision Viewer\n" +
                    "Enter an article name.");
            String articleName = console.next();
            String userJsonString = new GetterUtils().JsonStringGetter(articleName);
            String revision = ParseUtils.ParseToJsonArray(userJsonString).toString();
        Editor[] editArr = ParseUtils.ParseArrayToObjs(revision);
        Editor mostFreqEditor = AnalysisUtils.mostFrequentEdit(editArr);
        System.out.println(mostFreqEditor);

        for (Editor editor : editArr) {
            System.out.println(editor);
        }


    }
}
