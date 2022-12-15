package JP2.SuperMarket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamRepository implements ISanPhamInterface{
    @Override
    public ArrayList<SanPham> list1() {
        try {
            String txt_sql1 = "select * from quanlysanpham";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql1);
            ResultSet sr = stt.executeQuery(txt_sql1);
            ArrayList<SanPham> list1 = new ArrayList<>();
            while (sr.next()) {
                SanPham p = new SanPham(
                        sr.getInt("masp"),
                        sr.getString("tensp"),
                        sr.getString("mota"),
                        sr.getInt("price"),
                        sr.getInt("tonkho")
                );
                list1.add(p);
            }
                return list1;
        }catch (Exception e){
        }
        return null;
    }


    @Override
    public void create(SanPham sanPham) {
        String sql_txt1 = "insert into quanlysanpham (tensp,mota,tonkho,price) values(?,?,?,?)";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt1);
            stt.setString(1, sanPham.getTensp());
            stt.setString(2,sanPham.getMota());
            stt.setString(3, sanPham.getTonkho().toString());
            stt.setString(4, sanPham.getPrice().toString());
            stt.execute();
        }catch(Exception e){

        }

    }

    @Override
    public void update(SanPham sanPham) {
        String sql_txt1 = "update quanlysanpham set tensp=?,mota=?, tonkho=?, price=? Where masp=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt1);
            stt.setString(1, sanPham.getTensp());
            stt.setString(2,sanPham.getMota());
            stt.setString(3, sanPham.getTonkho().toString());
            stt.setString(4, sanPham.getPrice().toString());
            stt.setInt(5,sanPham.getMasp());
            stt.execute();
        }catch (Exception e){

        }
    }

    @Override
    public void delete(SanPham sanPham) {
        String delete = "delete from quanlysanpham where masp=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(delete);
            stt.setInt(1,sanPham.getMasp());
            stt.execute();
        }catch (Exception e){}
    }
}
