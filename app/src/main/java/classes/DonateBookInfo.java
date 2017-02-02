package classes;

/**
 * Created by junejaspc on 2/2/17.
 */

public class DonateBookInfo {
    String bookname,author,address,name,mobile,mrp,year;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public DonateBookInfo(String year, String bookname, String author, String address, String name, String mobile, String mrp) {

        this.year = year;
        this.bookname = bookname;
        this.author = author;
        this.address = address;
        this.name = name;
        this.mobile = mobile;
        this.mrp = mrp;
    }
}


