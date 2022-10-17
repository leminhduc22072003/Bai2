package session5lab2;

public class Main {
    public static void main(String[] args){
        KhachHangVietNam khvn1 = new KhachHangVietNam();
        khvn1.setId("D01");
        khvn1.setName("Vũ Châu Nguyệt Cầm");
        khvn1.setDate("1/2019");
        khvn1.setDoituong(khvn1.danhsachdoituong[0]);
        khvn1.setSoluong(70);
        khvn1.tinhTien();
        khvn1.hienThi();

        KhachHangVietNam khvn2 = new KhachHangVietNam();
        khvn2.setId("D02");
        khvn2.setName("Đỗ Hà Linh");
        khvn2.setDate("1/2019");
        khvn2.setDoituong(khvn1.danhsachdoituong[1]);
        khvn2.setSoluong(2000);
        khvn2.tinhTien();
        khvn2.hienThi();

        KhachHangNuocNgoai khnn1 = new KhachHangNuocNgoai("D03","Leonardo da Vinci");
        khnn1.setDate("2/2019");
        khnn1.setQuoctich("Italian");
        khnn1.setSoluong(230);
        khnn1.tinhTien();
        khnn1.hienThi();

        KhachHangNuocNgoai khnn2 = new KhachHangNuocNgoai("D04","La Lisa");
        khnn2.setDate("1/2019");
        khnn2.setQuoctich("Thai");
        khnn2.setSoluong(140);
        khnn2.tinhTien();
        khnn2.hienThi();

        KhachHangNuocNgoai khnn3 = new KhachHangNuocNgoai("D05","Triệu Lộ Tư");
        khnn3.setDate("2/2019");
        khnn3.setQuoctich("Chinese");
        khnn3.setSoluong(186);
        khnn3.tinhTien();
        khnn3.hienThi();

        DSKH dskh12019 = new DSKH();
        dskh12019.themKH(khvn1.date,khvn1.id,khvn1.name,khvn1.doituong,khvn1.soluong,khvn1.thanhTien);
        dskh12019.themKH(khvn2.date,khvn2.id,khvn2.name,khvn2.doituong,khvn2.soluong,khvn2.thanhTien);
        dskh12019.themKH(khnn1.date,khnn1.id,khnn1.name,khnn1.quoctich,khnn1.soluong,khnn1.thanhTien);
        dskh12019.themKH(khnn2.date,khnn2.id,khnn2.name,khnn2.quoctich,khnn2.soluong,khnn2.thanhTien);
        dskh12019.themKH(khnn3.date,khnn3.id,khnn3.name,khnn3.quoctich,khnn3.soluong,khnn3.thanhTien);
        dskh12019.hienThi("1/2019");
        dskh12019.hienThi("2/2019");
        dskh12019.tongSoLuong();
        dskh12019.trungBinhNN();
        System.out.println("Tổng số lượng của khách Việt Nam: " + dskh12019.tongVN);
        System.out.println("Tổng số lượng của khách nước ngoài: " + dskh12019.tongNN);
        System.out.format("Tiền điện trung bình của người nước ngoài: %.3f", dskh12019.trungbinh);
    }
}