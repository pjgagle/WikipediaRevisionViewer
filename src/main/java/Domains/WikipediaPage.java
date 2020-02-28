package Domains;

public class WikipediaPage {
    private String pgTitle;
    private int pgId;
    private Editor[] pgEditors;
    private Redirect redirect;

    public WikipediaPage(String pageTitle, int pageId, Editor[] pageEditors) {
        this.pgTitle = pageTitle;
        this.pgId = pageId;
        this.pgEditors = pageEditors;
    }

    public WikipediaPage(String pageTitle, int pageId, Editor[] pageEditors, Redirect redirect) {
        this.pgTitle = pageTitle;
        this.pgId = pageId;
        this.pgEditors = pageEditors;
        this.redirect = redirect;
    }

    public String getPageTitle() {
        return pgTitle;
    }

    public int getPageId() {
        return pgId;
    }

    public Editor[] getPageEditors() {
        return pgEditors;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    @Override
    public String toString() {
        return "WikiPage{" +
                ", pageTitle=" + pgTitle + '\'' +
                ", pageId=" + pgId + '\'' +
                ", pageEditors=" + pgEditors + '\'' +
                ", redirect=" + redirect + '}';
    }

}

