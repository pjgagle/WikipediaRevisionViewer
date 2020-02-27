package Domains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Editor {
    private String user;
    private Date timeStamp;
    private int numberEdits;

    public Editor(String theUser, String theTimeStamp) throws ParseException {
        user = theUser;
        timeStamp = parseDate(theTimeStamp);

    }
    public Date parseDate(String theDate) throws ParseException {
        SimpleDateFormat newDate = new SimpleDateFormat("yyyy-M-ddThh:mm:ssZ");
        String dateString = theDate;
        Date date = newDate.parse(dateString);
        return date;
    }

    public String getUser() {
        return user;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public int getNumberEdits() {
        return numberEdits;
    }

    public void setNumberEdits(int numberEdits) {
        this.numberEdits = numberEdits;
    }
    @Override
    public String toString() {
        return "Editor{" + "user='" +
                '\'' + ", timestamp=" + timeStamp +
                '}';
    }
}
