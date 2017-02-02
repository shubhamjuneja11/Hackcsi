package classes;

import probeginners.hackcsi.NavActivity;

/**
 * Created by junejaspc on 2/2/17.
 */

public class DonateBookInfo {
    public String bookname;
    public String author;
    public String address;
    public String name;
    public String mobile;
    public String mrp;
    public String year;
    public String email;
    public String status;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



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

    public DonateBookInfo(String year, String bookname, String author, String address, String name, String mobile, String mrp,String status) {

        this.year = year;
        this.bookname = bookname;
        this.author = author;
        this.address = address;
        this.name = name;
        this.mobile = mobile;
        this.mrp = mrp;
        this.email= NavActivity.email;
        this.status=status;
    }
    public DonateBookInfo(){}
}


