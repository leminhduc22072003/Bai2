package JP2.SuperMarket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SanPhamForm {
    public TextField pMaSP;
    public TextField pTensp;
    public TextArea pMota;
    public TextField pTonkho;
    public TextField pPrice;
    private SanPham editData1;





    public void backSanPham() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SanPham.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit1(ActionEvent event) {
        String tensanpham = this.pTensp.getText();
        String motasanpham = this.pMota.getText();
        String sanphamtonkho = this.pTonkho.getText();
        String giasanpham = this.pPrice.getText();
        try {

            SanPhamRepository sp = new SanPhamRepository();
            if(this.editData1 == null) {
                SanPham p = new SanPham(null,tensanpham, motasanpham,Integer.parseInt(sanphamtonkho),Integer.parseInt(giasanpham));
                sp.create(p);
            }else{
                SanPham p = new SanPham(editData1.getMasp(),tensanpham,motasanpham,Integer.parseInt(sanphamtonkho),Integer.parseInt(giasanpham));
                sp.update(p);
            }
            this.backSanPham();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }public void setEditData1(SanPham editData1) {
        this.editData1 = editData1;
        this.pMaSP.setText(editData1.getMasp().toString());
        this.pMaSP.setDisable(true);
        this.pTensp.setText(editData1.getTensp());
        this.pMota.setText(editData1.getMota());
        this.pTonkho.setText(editData1.getTonkho().toString());
        this.pPrice.setText(editData1.getPrice().toString());
    }

}