package Domains;

public class Redirect {
    private String from;
    private String to;

    public Redirect(String theFrom, String theTo) {
        from = theFrom;
        to = theTo;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
