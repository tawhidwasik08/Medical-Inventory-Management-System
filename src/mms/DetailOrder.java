package mms;

public class DetailOrder {

    private int order_no, c_id;
    private String order_time, order_prcsd;
    private float order_val;

    public DetailOrder(int order_no, int c_id, String order_time, float order_val, String order_prcsd) {

        this.order_no=order_no;
        this.c_id=c_id;
        this.order_prcsd=order_prcsd;
        this.order_time=order_time;
        this.order_val=order_val;
    }

    public int getOrder_no() {
        return order_no;
    }

    public int getC_id() {
        return c_id;
    }

    public String getOrder_prcsd() {
        return order_prcsd;
    }

    public String getOrder_time() {
        return order_time;
    }

    public float getOrder_val() {
        return order_val;
    }

}
