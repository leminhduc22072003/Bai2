package JP2.SuperMarket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangRepository implements KhachHangInterface {

    @Override
    public ArrayList<KhachHang> list() {
        try {
            String txt_sql = "select * from khachhang";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery(txt_sql);

            ArrayList<KhachHang> list = new ArrayList<>();
            while (rs.next()){
                KhachHang s = new KhachHang(
                        rs.getInt("makh"),
                        rs.getString("hoten"),
                        rs.getString("sodt")
                );
                list.add(s);
            }
            return list;
        }catch (Exception e){}
        return null;
    }

    @Override
    public void creat(KhachHang khachHang) {
        String sql_txt = "insert into khachhang (hoten,sodt) values(?,?)";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,khachHang.getHoten());
            stt.setString(2,khachHang.getSodt());
            stt.execute();
        }catch (Exception e){}
    }

    @Override
    public void update(KhachHang khachHang) {
        String sql_txt = "update khachhang set hoten=?,sodt=? Where makh=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,khachHang.getHoten());
            stt.setString(2,khachHang.getSodt());
            stt.setInt(3,khachHang.getMakh());
            stt.execute();
        }catch (Exception e){}
    }

    @Override
    public void delete(KhachHang khachHang) {
        String sql_txt = "delete from khachhang where makh=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setInt(1,khachHang.getMakh());
            stt.execute();
        }catch (Exception e){}
    }
}

