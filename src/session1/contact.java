package session1;

import java.util.ArrayList;

public class contact{
    public String name;
    public ArrayList<String> phone = new ArrayList<String>();
    public contact(String name, String phone){
        this.name = name;
        this.phone.add(phone);
    }
}