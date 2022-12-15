package JP2.SuperMarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class KhachHang {
    public Integer makh ;
    public String hoten;
    public String sodt;
    public Button sua;
    public Button xoa;

    public KhachHang(Integer makh, String hoten, String sodt) {
        this.makh = makh;
        this.hoten = hoten;
        this.sodt = sodt;
        this.sua = new Button("Sua");
        this.sua.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("KhachHangForm.fxml"));
                Parent root = loader.load();
                Main.rootStage.setScene(new Scene(root,800,600));
                KhachHangForm d = loader.getController();
                d.setEditData(this);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        this.xoa = new Button("Xoa");
        this.xoa.setOnAction(event -> {
            try {
                KhachHangRepository khr = new KhachHangRepository();
                khr.delete(this);
                KhachHangForm kh = new KhachHangForm();
                kh.backKhachHang();
            }
            catch (Exception ignored){}
        });
    }

    public Integer getMakh() {
        return makh;
    }

    public void setMakh(Integer makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
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
