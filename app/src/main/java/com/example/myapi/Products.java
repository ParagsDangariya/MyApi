package com.example.myapi;

public class Products {

    String pimg,Pname;

    public Products(String pimg, String pname) {
        this.pimg = pimg;
        Pname = pname;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }
}
