package JP2.SuperMarket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NhanVienFormController  {
    public TextField sHoTen;
    public TextField sSDT;
    public TextArea sDiaChi;
    public NhanVien editData;


    public void backNhanVien() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NhanVien.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void Submit(ActionEvent event){
            String  hoten = this.sHoTen.getText();
            String sodt = this.sSDT.getText();
            String diachi = this.sDiaChi.getText();
            try {
                NhanVienRepository nvr = new NhanVienRepository();
                if (this.editData == null){
                    NhanVien n = new NhanVien(null,hoten,sodt,diachi);
                    nvr.create(n);
                }else {
                    NhanVien n = new NhanVien(editData.getManv(), hoten, sodt, diachi);
                    nvr.update(n);
                }
                this.backNhanVien();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
    public void setEditData(NhanVien editData){

        this.editData = editData;
        this.sHoTen.setText(editData.getHoten());
        this.sSDT.setText(editData.getSodt());
        this.sDiaChi.setText(editData.getDiachi());
    }



}