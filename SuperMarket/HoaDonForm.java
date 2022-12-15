package JP2.SuperMarket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

public  class HoaDonForm implements Initializable {
    public TextField hMaHD;
    public ComboBox<HoaDon> hMaNV;
    public ComboBox<HoaDon> hMaKH;
    public ComboBox<HoaDon> hMaSP;
    public TextField hSL;
    public TextField hGG;
    public DatePicker hNRHD;
    public TextField hTT;
    public HoaDon editData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        QLHDRepository qlhd = new QLHDRepository();
        ArrayList<HoaDon> ls = qlhd.list();
        ObservableList<HoaDon> hhlist = FXCollections.observableArrayList();
        hhlist.addAll(ls);
        hMaKH.setItems(hhlist);
        hMaNV.setItems(hhlist);
        hMaSP.setItems(hhlist);
    }

    public void Submit(ActionEvent event) {
        Integer sl = Integer.valueOf(this.hSL.getText());
        Double gg = Double.valueOf(this.hGG.getText());
        Double tt = Double.valueOf(this.hTT.getText());

        HoaDon selectedHoaDon = hMaKH.getSelectionModel().getSelectedItem();
        Integer mkh = selectedHoaDon.getMakh();
        Integer mnv = selectedHoaDon.getManv();
        Integer msp = selectedHoaDon.getMasp();
        Date nhd = Date.valueOf(String.valueOf(selectedHoaDon.getNgayhd()));
        try {
            QLHDRepository hd = new QLHDRepository();
            if(this.editData == null) {
                HoaDon h = new HoaDon(null,mnv,mkh,msp,sl,gg,nhd,tt);
                hd.creat(h);
            }else{
                hd.update(this.editData);
            }
            this.backHoaDon();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setEditData(HoaDon editData) {
        this.editData = editData;
        this.hMaHD.setText(editData.getMahd().toString());
        this.hSL.setText(editData.getSoluong().toString());
        this.hGG.setText(editData.getGiamgia().toString());
        this.hTT.setText(editData.getThanhtien().toString());

        for (int i = 0; i < this.hMaKH.getItems().size(); i++) {
            if (this.hMaKH.getItems().get(i).getMakh() == 2) {
                hMaKH.setValue(this.hMaKH.getItems().get(i));
                break;
            }
        }
        for (int i = 0; i < this.hMaNV.getItems().size(); i++) {
            if (this.hMaNV.getItems().get(i).getManv() == 2) {
                hMaNV.setValue(this.hMaNV.getItems().get(i));
                break;
            }
        }
        for (int i = 0; i < this.hMaSP.getItems().size(); i++) {
            if (this.hMaSP.getItems().get(i).getMasp() == 2) {
                hMaSP.setValue(this.hMaSP.getItems().get(i));
                break;
            }
        }
    }

    public void backHoaDon() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HoaDon.fxml"));
        Main.rootStage.setScene(new Scene(root, 1050, 700));
    }
}
