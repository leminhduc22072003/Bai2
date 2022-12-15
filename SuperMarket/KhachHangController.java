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
import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class KhachHangController implements Initializable {
    public TableView<KhachHang> tbKhachHang;
    public TableColumn<KhachHang,Integer> sMKH;
    public TableColumn<KhachHang,String> sTen;
    public TableColumn<KhachHang,String> sSDT;
    public TableColumn<KhachHang,Button> sSua;
    public TableColumn<KhachHang,Button> sXoa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sMKH.setCellValueFactory(new PropertyValueFactory<>("makh"));
        sTen.setCellValueFactory(new PropertyValueFactory<>("hoten"));
        sSDT.setCellValueFactory(new PropertyValueFactory<>("sodt"));
        sSua.setCellValueFactory(new PropertyValueFactory<>("Sua"));
        sXoa.setCellValueFactory(new PropertyValueFactory<>("Xoa"));
        try {
            KhachHangRepository kh = new KhachHangRepository();
            ArrayList<KhachHang> akh = kh.list();
            ObservableList<KhachHang> list = FXCollections.observableArrayList();
            list.addAll(akh);
            tbKhachHang.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.rootStage.setScene(new Scene(root,600,400));
    }

    public void addKH(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("KhachHangForm.fxml"));
        Main.rootStage.setScene(new Scene(root,700,500));
    }
}
