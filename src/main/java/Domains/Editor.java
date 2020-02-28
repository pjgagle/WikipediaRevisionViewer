package Domains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Editor {
    private String user;
    private String timestamp;

    public Editor(String user, String time) throws ParseException {
        this.user = user;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        this.timestamp = String.valueOf(simpleDateFormat.parse(time));
    }

    public String getUser() {
        return user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Editor {" +
                "Username: " + user + '\'' +
                "Timestamp: " + timestamp + '\'' +
                '}';
    }
}
