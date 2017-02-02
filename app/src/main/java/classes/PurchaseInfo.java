package classes;

/**
 * Created by junejaspc on 2/2/17.
 */

public class PurchaseInfo {
    String bookname;
    String author;
    String mrp;
    public PurchaseInfo(String bookname, String author, String mrp) {
        this.bookname = bookname;
        this.author = author;
        this.mrp = mrp;
    }

    public String getBookname() {

        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
