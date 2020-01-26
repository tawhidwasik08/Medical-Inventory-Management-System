package mms;

public class Stock {
    
    private int id,qty;
    private float price;
    private String med_name,manf_name,exp_date;
    
    public Stock(int id,String med_name,float price,int qty,String manf_name,String exp_date){
        this.id=id;
        this.qty=qty;
        this.price=price;
        this.med_name=med_name;
        this.manf_name=manf_name;
        this.exp_date=exp_date;
    
}

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public String getMed_name() {
        return med_name;
    }


    public int getId() {
        return id;
    }

    public String getManf_name() {
        return manf_name;
    }

    public String getExp_date() {
        return exp_date;
    }
    
}
