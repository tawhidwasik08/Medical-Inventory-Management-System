
package mms;

class Medicine {
    
    private int id,qt;
    private String name;
    private float price;
    
    public Medicine(int id,String name,float price,int qt){
        this.id=id;
        this.name=name;
        this.price=price;
        this.qt=qt;
    }

    public int getId() {
        return id;
    }

    public int getQt() {
        return qt;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    
    
}
