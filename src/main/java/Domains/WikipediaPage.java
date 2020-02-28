package Domains;

import java.util.List;

public class WikipediaPage {
    private String pgTitle;
    private int pgId;
    private List<Editor> pgEditors;
    private Redirect redirect;

    public WikipediaPage(String thePgTitle, int thePgId, List<Editor> theEditorList) {
        pgTitle = thePgTitle;
        pgId = thePgId;
        pgEditors = theEditorList;

    }
    public WikipediaPage(String thePgTitle, int thePgId, List<Editor> theEditorList, Redirect theRedirect) {
        pgTitle = thePgTitle;
        pgId = thePgId;
        pgEditors = theEditorList;
        redirect = theRedirect;

    }

    public String getPgTitle() {
        return pgTitle;
    }

    public int getPgId() {
        return pgId;
    }

    public List<Editor> getPgEditors() {
        return pgEditors;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setPgTitle(String pgTitle) {
        this.pgTitle = pgTitle;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    public void setPgEditors(List<Editor> pgEditors) {
        this.pgEditors = pgEditors;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    @Override
    public String toString(){
        return "WikipediaPage{" + "pageTitle='" + pgTitle +
                '\'' + ", pageID=" + pgId + ", pageEditors=" +
                pgEditors + ", redirect=" + redirect + '}';
    }
}
