import Domains.Editor;
import Domains.WikipediaPage;
import Exceptions.NetworkConnectionFailException;
import Exceptions.NoWikiPageFoundException;
import Exceptions.ParameterIsNotJsonStringException;
import util.AnalysisUtils;
import util.GetterUtils;
import util.ParseUtils;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, ParameterIsNotJsonStringException, NetworkConnectionFailException {
        try(Scanner console = new Scanner(System.in)) {
            System.out.println("Wikipedia Revision Viewer\n" +
                    "Enter an article name.");
            String articleName = console.next();
            String userJsonString = new GetterUtils().JsonStringGetter(articleName);
            String revision = ParseUtils.ParseJsonToObjects(userJsonString).toString();
            WikipediaPage editArr = ParseUtils.ParseJsonToObjects(revision);
            Editor mostFreqEditor = AnalysisUtils.mostFrequentEdit(editArr);
            System.out.println(mostFreqEditor);
            WikipediaPage userWiki = ParseUtils.ParseJsonToObjects(userJsonString);
            if (userWiki.getRedirect() != null) {
                System.out.println("Redirected from " + articleName + " to " + userWiki.getPageTitle());
            }

            System.out.println("Recent editors: ");
            for (Editor i : userWiki.getPageEditors()) {
                System.out.println(i);
            }

            System.out.println("\nEditors with their counts:");


        } catch (ParameterIsNotJsonStringException e) {
            System.out.println("Parameter is not Json string exception.");
        } catch (NoWikiPageFoundException e) {
            System.out.println("No Wikipedia page for word exception.");
        }

        }



}
