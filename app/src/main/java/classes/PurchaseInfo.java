package classes;

/**
 * Created by junejaspc on 2/2/17.
 */

public class PurchaseInfo {
    String bookname;
    String author;
    String mrp;
    String email;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PurchaseInfo(String bookname, String author, String mrp, String email, String status) {

        this.bookname = bookname;
        this.author = author;
        this.mrp = mrp;
        this.email = email;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public PurchaseInfo(){}
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
