package JP2.SuperMarket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HoaDonController implements Initializable {

    public TableView<HoaDon> tbHoaDon;
    public TableColumn<HoaDon,Integer> sMaHD;
    public TableColumn<HoaDon,Integer> sMaNV;
    public TableColumn<HoaDon,Integer> sMaKH;
    public TableColumn<HoaDon,Integer> sMaSP;
    public TableColumn<HoaDon,Integer> sSL;
    public TableColumn<HoaDon,Double> sGG;
    public TableColumn<HoaDon, Date> sNRHD;
    public TableColumn<HoaDon,Double> sTT;
    public TableColumn<HoaDon,Button> sSua;
    public TableColumn<HoaDon,Button> sXoa;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sMaHD.setCellValueFactory(new PropertyValueFactory<>("mahd"));
        sMaNV.setCellValueFactory(new PropertyValueFactory<>("manv"));
        sMaKH.setCellValueFactory(new PropertyValueFactory<>("makh"));
        sMaSP.setCellValueFactory(new PropertyValueFactory<>("masp"));
        sSL.setCellValueFactory(new PropertyValueFactory<>("soluong"));
        sGG.setCellValueFactory(new PropertyValueFactory<>("giamgia"));
        sNRHD.setCellValueFactory(new PropertyValueFactory<>("ngayhd"));
        sTT.setCellValueFactory(new PropertyValueFactory<>("thanhtien"));
        sSua.setCellValueFactory(new PropertyValueFactory<>("sua"));
        sXoa.setCellValueFactory(new PropertyValueFactory<>("xoa"));

        try {
            QLHDRepository hd = new QLHDRepository();
            ArrayList<HoaDon> ahd = hd.list();
            ObservableList<HoaDon> list = FXCollections.observableArrayList();
            list.addAll(ahd);
            tbHoaDon.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backHoaDon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void addHoaDon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HoaDonForm.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }
}
