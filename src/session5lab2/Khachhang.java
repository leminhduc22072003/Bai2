package session5lab2;

import java.util.ArrayList;

public class KhachHang {
    String id,name,date;
    double thanhTien;
    int soluong;
    int[] dinhmuc = {50,100,200};
    double[] dinhmucgia = {1000,1200,1500,2000};

    public KhachHang(){
        System.out.println("\nThông tin hóa đơn");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void hienThi(){
        System.out.println("Mã khách hàng: " + getId());
        System.out.println("Họ tên: " + getName());
        System.out.println("Ngày ra hóa đơn: " + getDate());
        System.out.println("Số lượng tiêu thụ (KW): " + getSoluong());
    }
}