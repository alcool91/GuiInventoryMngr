package guiinventorymngr;
import java.util.*;
import java.io.*;
public class Inventory {
    Entry entry[] = new Entry[200];
    int numEntries;
    
    
    Inventory() {

    }
    public void populate(String fileName) throws Exception{
        String name, number, notes;
        File F = new File(fileName);
        Scanner filein = new Scanner(F);
        int i;
        i=0;
        while (filein.hasNext()) {
            name = filein.next();
            number = filein.next();
            filein.skip("\t");
            notes = filein.nextLine();
            entry[i] = new Entry(name, number, notes);
            i++;
        }
        System.out.println("Successfully loaded inventory from " + fileName);
        sort();
    }
    
    public void save(String fileName) throws Exception{
        File F = new File(fileName);
        PrintStream P = new PrintStream(F);
        numEntries = getNumEntries();
        for (int i = 0; i < numEntries; i++) {
            P.println(entry[i].getName() + "\t" +
                      entry[i].getNumber() + "\t" +
                      entry[i].getNotes());
            }
        P.close();
        System.out.println("Inventory Stored");   
    }
    
    public String getName(int index) {
        return entry[index].getName();
    }
    
    public String getQnty(int index) {
        return entry[index].getNumber();
    }
    
    public String getNotes(int index) {
        return entry[index].getNotes();
    }
    
    public void setQnty(int index, String quantity) {
        entry[index].setNumber(quantity);
    }
    
    public void setNotes(int index, String notes) {
        entry[index].setNotes(notes);
    }
    
    public int add(Entry toAdd) throws Exception{
        int index;
        numEntries = getNumEntries();
        if (toAdd.getName() .equals("null"))
            return 3;
        else if(numEntries >= 200)
            return 4;
        else if ((toAdd.getName().length() > 9) || (toAdd.getName().length() < 1 ))
            return 1;
        else if (Find(toAdd) >= 0)
            return 2;
        else {
            index = Math.abs(Find(toAdd)) - 1;
            for(int i = numEntries; i >= index; i--) 
                entry[i+1] = entry[i];
            entry[index] = toAdd;
            return 0;
        }
    }
    
    public int Find(Entry toFind) {
        int low, mid, high;
        String name = toFind.getName();
        numEntries = getNumEntries();
        if (numEntries == 0)
            return -1;       
        low = 0;
        high = numEntries-1;
        while (high >= low) {
            mid = (high + low)/2;
            if(entry[mid].getName().compareToIgnoreCase(name) < 0) 
                low = mid+1;
            else if (entry[mid].getName().compareToIgnoreCase(name) == 0)
                return mid;
            else if (entry[mid].getName().compareToIgnoreCase(name) > 0) 
                high = mid-1;
            
        }
        return -low-1;
        }
    public int Find(String toFind) {
        int low, mid, high;
        String name = toFind;
        numEntries = getNumEntries();
        if (numEntries == 0)
            return -1;       
        low = 0;
        high = numEntries-1;
        while (high >= low) {
            mid = (high + low)/2;
            if(entry[mid].getName().compareToIgnoreCase(name) < 0) 
                low = mid+1;
            else if (entry[mid].getName().compareToIgnoreCase(name) == 0)
                return mid;
            else if (entry[mid].getName().compareToIgnoreCase(name) > 0) 
                high = mid-1;
            
        }
        return -low-1;
    }
    
    public void remove(int index) {
        numEntries = getNumEntries();
        for (int i=index + 1; i<= numEntries; i++) {
            entry[i-1] = entry[i];            
        }
        Entry.decrement();
    }
    
    
    public int getNumEntries() {
        numEntries = 0;
        for(int i = 0; entry[i] != null; i++) {
            numEntries++;
        }
        return numEntries;
    }
    
    private void sort() {
        Entry temp, min;
        int index;
        numEntries = getNumEntries();
        if (numEntries < 2)
            return;
        for(int i = 0; i < numEntries; i++) {
            min = entry[i];
            index = i;
            temp = entry[i];
            for(int j=i+1; j < numEntries; j++) {
                if (entry[j].getName().compareToIgnoreCase(min.getName()) < 0) {
                    min = entry[j];
                    index = j;
                }
            }
            entry[i] = min;
            entry[index] = temp;
        }
    }
    
}
