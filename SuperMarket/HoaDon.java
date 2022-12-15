package JP2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.Date;

public class HoaDon {
    public Integer mahd;
    public Integer manv;
    public Integer makh;
    public Integer masp;
    public Integer soluong;
    public Double giamgia;
    public Date ngayhd;
    public Double thanhtien;
    public Button sua;
    public Button xoa;

    public HoaDon(Integer mahd, Integer manv, Integer makh, Integer masp, Integer soluong, Double giamgia, Date ngayhd, Double thanhtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.masp = masp;
        this.soluong = soluong;
        this.giamgia = giamgia;
        this.ngayhd = ngayhd;
        this.thanhtien = thanhtien;
        this.sua = new Button("Sua");
        this.xoa = new Button("Xoa");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HoaDonForm.fxml"));
                Parent root = loader.load();
                Main.rootStage.setScene(new Scene(root,800,600));
                HoaDonForm h = loader.getController();
                h.setEditData(this);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        this.xoa.setOnAction(event -> {
            try {
                QLHDRepository qlhd = new QLHDRepository();
                qlhd.delete(this);
                HoaDonForm hh = new HoaDonForm();
                hh.backHoaDon();
            }
            catch (Exception ignored){}
        });

    }

    public Integer getMahd() {
        return mahd;
    }

    public void setMahd(Integer mahd) {
        this.mahd = mahd;
    }

    public Integer getManv() {
        return manv;
    }

    public void setManv(Integer manv) {
        this.manv = manv;
    }

    public Integer getMakh() {
        return makh;
    }

    public void setMakh(Integer makh) {
        this.makh = makh;
    }

    public Integer getMasp() {
        return masp;
    }

    public void setMasp(Integer masp) {
        this.masp = masp;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Double getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(Double giamgia) {
        this.giamgia = giamgia;
    }

    public Date getNgayhd() {
        return ngayhd;
    }

    public void setNgayhd(Date ngayhd) {
        this.ngayhd = ngayhd;
    }

    public Double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Button getSua() {
        return sua;
    }

    public void setSua(Button sua) {
        this.sua = sua;
    }

    public Button getXoa() {
        return xoa;
    }

    public void setXoa(Button xoa) {
        this.xoa = xoa;
    }
}
