package probeginners.hackcsi.Models;

import java.util.ArrayList;

/**
 * Created by rishabhshukla on 02/02/17.
 */

public class BooksVol {
    String kind;
    int totalItems;
    ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public String getKind() {
        return kind;
    }
}
