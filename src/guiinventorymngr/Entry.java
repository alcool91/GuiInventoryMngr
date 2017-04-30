package guiinventorymngr;
public class Entry {
    private final String name;
    private String number, notes;
    private static int numEntries;
    static {
        numEntries = 0;
    }
    public Entry(String Name, String Number, String Notes) {
        this.name = Name;
        this.number = Number;
        this.notes = Notes;
        numEntries++;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public String getNotes() {
        return notes;
    }
    public static int getNumEntries() {
        return numEntries;
    }
    public static void decrement() {
        numEntries--;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}