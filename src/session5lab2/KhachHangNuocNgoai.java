package session5lab2;

public class KhachHangNuocNgoai extends KhachHang {
    String quoctich;

    public KhachHangNuocNgoai(String id,String name){
        setId(id);
        setName(name);
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }

    public double tinhTien(){
        if(soluong<dinhmuc[0]){
            thanhTien = soluong*dinhmucgia[0];
        }else if(soluong<dinhmuc[1]){
            thanhTien = soluong*dinhmucgia[1];
        }else if(soluong<dinhmuc[2]){
            thanhTien = soluong*dinhmucgia[2];
        } else {
            thanhTien = soluong*dinhmucgia[3];
        }
        return thanhTien;
    }

    public void hienThi(){
        System.out.println("Đối tượng khách hàng: " + getQuoctich());
        super.hienThi();
        System.out.println("Tổng tiền điện: " + getThanhTien());
    }
}