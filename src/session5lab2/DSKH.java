package session5lab2;

import java.util.ArrayList;

public class DSKH {
    ArrayList<infor> DSKH = new ArrayList<infor>();
    String[] danhsachdoituong = {"Sinh hoạt", "Kinh doanh", "Sản xuất"};
    double  tongVN= 0,tongNN=0,trungbinh;

    public void themKH(String date, String id, String name, String doituong, int soluong, double thanhTien){
        DSKH.add(new infor(date,id,name,doituong,soluong,thanhTien));
    }

    public void hienThi(String date){
        System.out.println("\nDanh sách người dùng tháng " + date);
        System.out.println("| ID |      Họ và tên     |  Đối tượng  | Số lượng | Tổng tiền điện |");
        for(infor i:DSKH){
            if(i.date.equals(date)){
                System.out.format("|%4s|%20s|%13s|%10d|%16.2f|\n",i.id,i.name,i.doituong,i.soluong,i.thanhTien);
            }
        }
    }

    public void tongSoLuong(){
        for(infor i:DSKH){
            if(i.doituong.equals(danhsachdoituong[0]) || i.doituong.equals(danhsachdoituong[1]) || i.doituong.equals(danhsachdoituong[2])){
                tongVN +=i.soluong;
            }else {
                tongNN += i.soluong;
            }
        }
    }

    public void trungBinhNN(){
        double tong=0,songuoinn=0;
        for(infor i:DSKH){
            if(i.doituong.compareTo(danhsachdoituong[0]) != 0&&i.doituong.compareTo(danhsachdoituong[1]) != 0&&i.doituong.compareTo(danhsachdoituong[2])!=0){
                tong += i.thanhTien;
                songuoinn++;
            }
        }
        trungbinh = tong/songuoinn;
    }
}