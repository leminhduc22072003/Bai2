package session5lab2;

public class KhachHangVietNam extends KhachHang {
    String doituong;
    String[] danhsachdoituong = {"Sinh hoạt", "Kinh doanh", "Sản xuất"};

    public String getDoituong() {
        return doituong;
    }

    public void setDoituong(String doituong) {
        this.doituong = doituong;
    }

    public double tinhTien() {
        if (soluong < dinhmuc[0]) {
            thanhTien = soluong * dinhmucgia[0];
        } else if (soluong < dinhmuc[1]) {
            thanhTien = (dinhmuc[0] - 1) * dinhmucgia[0] + (soluong - dinhmuc[0]) * dinhmucgia[1];
        } else if (soluong < dinhmuc[2]) {
            thanhTien = (dinhmuc[0] - 1) * dinhmucgia[0] + (dinhmuc[1] - dinhmuc[0] - 1) * dinhmucgia[1] + (soluong - dinhmuc[1]) * dinhmucgia[2];
        } else {
            thanhTien = (dinhmuc[0] - 1) * dinhmucgia[0] + (dinhmuc[1] - dinhmuc[0] - 1) * dinhmucgia[1] + (dinhmuc[2] - dinhmuc[1] - 1) * dinhmucgia[2] + (soluong - dinhmuc[2]) * dinhmucgia[3];
        }
        return thanhTien;
    }

    public void hienThi() {
        System.out.println("Đối tượng khách hàng: " + getDoituong());
        super.hienThi();
        System.out.println("Tổng tiền điện: " + getThanhTien());
    }
}
