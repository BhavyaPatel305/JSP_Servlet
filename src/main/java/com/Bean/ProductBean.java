package com.Bean;

public class ProductBean {
    private String pname;
    private String price;
    private String qty;
    private String category;

    public void setPname(String pname){
        this.pname = pname;
    }
    public String getPname(){
        return pname;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return price;
    }
    public void setQty(String qty){
        this.qty = qty;
    }
    public String getQty(){
        return qty;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
}
