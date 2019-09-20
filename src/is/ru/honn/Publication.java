package is.ru.honn;

public class Publication {
    private String editorName;
    private String title;
    private String journal;
    private int year;
    private boolean type; // 1 = printed, 0 = electronic

    public Publication() {}

    public Publication(String editorName, String title, String journal, int year, boolean type) {
        this.editorName = editorName;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.type = type;
    }

    //GETTERS
    public String getEditorName() {
        return editorName;
    }

    public String getTitle() {
        return title;
    }

    public String getJournal() {
        return journal;
    }

    public int getYear() {
        return year;
    }

    //SETTERS

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Since the type is stored as a boolean we need to convert
    // it to a user friendly readable format
    private String getTypeName(boolean type) {
        if(type) {
            return "Printed";
        } else {
            return "Electronic";
        }
    }

    @Override
    public String toString() {
        return "Editor: "  + this.editorName + "\n" +
                "Title: " + this.title + "\n" +
                "Journal: " + this.journal + "\n" +
                "Year: " + this.year + "\n" +
                "Type: " + getTypeName(this.type) + "\n";
    }
}
