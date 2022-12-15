package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class KhachHangForm {
    public TextField sMaKH;
    public TextField sTen;
    public TextField sSDT;
    public KhachHang editData;

    public void backKhachHang() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("KhachHang.fxml"));
        Main.rootStage.setScene(new Scene(root, 700, 500));
    }

    public void submit(ActionEvent event) {
        String name = this.sTen.getText();
        String phone = this.sSDT.getText();
        try {
            KhachHangRepository khr = new KhachHangRepository();
            if (this.editData == null){
                KhachHang k = new KhachHang(null, name,phone);
                khr.creat(k);
            }
            else {
                KhachHang k = new KhachHang(editData.getMakh(), name,phone);
                khr.update(k);
            }
            this.backKhachHang();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setEditData(KhachHang editData) {
        this.editData = editData;
        this.sMaKH.setText(editData.getMakh().toString());
        this.sMaKH.setDisable(true);
        this.sTen.setText(editData.getHoten());
        this.sSDT.setText(editData.getSodt());
    }
}

