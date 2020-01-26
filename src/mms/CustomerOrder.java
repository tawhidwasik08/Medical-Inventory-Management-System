
package mms;

public class CustomerOrder {
    private int c_id,order_no;
    
    
    public CustomerOrder(int c_id,int order_no){
        this.c_id=c_id;
        this.order_no=order_no;
        
    }

    public int getC_id() {
        return c_id;
    }

    public int getOrder_no() {
        return order_no;
    }
    
}
