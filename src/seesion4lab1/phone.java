package session4lab1;

import java.util.*;

public class PhoneBook extends phone{
    public ArrayList<contact> PhoneList = new ArrayList();

    public void inputPhone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên liên hệ: ");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        System.out.println("Thêm thành công liên hệ " + name + " số điện thoại " + phone + " vào danh bạ");
        insertPhone(name,phone);
    }

    public void insertPhone(String name, String phone){
        for(contact ct:PhoneList){
            if(name.equals(ct.name){
                for(String s:ct.phone){
                    if(s==phone){
                        return;
                    }
                    ct.phone.add(phone);
                    return;
                }
            }
        }
        PhoneList.add(new contact(name,phone));
    }

    public void removePhone(String name){
        for(contact ct:PhoneList){
            if(name == ct.name){
                PhoneList.remove(ct);
                return;
            }
        }
    }

    public void updatePhone(String name, String newphone){
        for(contact ct:PhoneList){
            if(name.equals(ct.name){
                ct.phone.removeAll(ct.phone);
                ct.phone.add(newphone);
                System.out.println("Update thành công liên hệ " + ct.name + " số điện thoại: " + ct.phone);
                return;
            }
        }
        System.out.println("Liên hệ " + name + " chưa tồn tại");
        System.out.println("Bạn có muốn thêm " + name + " vào danh bạ không? \n1.Có - 2.Không");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x){
            case 1:
                inputPhone();
                break;
            case 2: return;
        }
    }

    public void searchPhone(String name){
        for(contact ct:PhoneList){
            if(name.equals(ct.name){
                System.out.println("Liên hệ: " + name);
                System.out.println("Số điện thoại: " + ct.phone);
                return;
            }
        }
        System.out.println("Liên hệ " + name + " chưa tồn tại");
        System.out.println("\nBạn có muốn thêm " + name + " vào danh bạ? \n1.Có - 2.Không");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x){
            case 1:
                inputPhone();
                break;
            case 2: return;
        }
    }

    public void sort(){
        if(PhoneList.size()==0) System.out.println("Danh bạ rỗng");
        else {
            Collections.sort(PhoneList, new Comparator<contact>() {
                @Override
                public int compare(contact o1, contact o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
            System.out.println("Danh bạ theo thứ tự tăng dần: ");
            for(contact ct:PhoneList){
                System.out.println(ct.name);
                System.out.println(ct.phone);
            }
            Collections.sort(PhoneList, new Comparator<contact>() {
                @Override
                public int compare(contact o1, contact o2) {
                    return o2.name.compareTo(o1.name);
                }
            });
            System.out.println("\nDanh bạ theo thứ tự giảm dần: ");
            for(contact ct:PhoneList){
                System.out.println(ct.name);
                System.out.println(ct.phone);
            }
        }
    }
}