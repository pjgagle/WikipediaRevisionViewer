package util;


import Exceptions.NetworkConnectionFailException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class GetterUtils {
    public String JsonStringGetter(String word) throws IOException, NetworkConnectionFailException {
        URL enteredUrl = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
        URLEncoder.encode(word, URLEncoder.encode("utf-8")) + "&rvprop=timestamp|user&rvlimit=30&redirects");
        URLConnection connect = enteredUrl.openConnection();
        connect.setRequestProperty("User-Agent",
                "Revision Tracker/0.1 (http://www.cs.bsu.edu/; yourusername@bsu.edu)");
        InputStream input = connect.getInputStream();
        Scanner console = new Scanner(System.in);
        String results = console.nextLine();

        if(results.isEmpty()) {
            throw new NetworkConnectionFailException();
        }
        return results;
    }
}
