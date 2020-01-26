
package mms;

public class Employee {

    private int id;
    private String name, phone, address, user_name, password;
    
    public Employee(int id,String name, String phone, String address, String user_name, String password){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.address=address;
        this.user_name=user_name;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }
    
    
    

}


