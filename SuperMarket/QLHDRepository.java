package JP2.SuperMarket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QLHDRepository implements QLHDInterface{
    @Override
    public ArrayList<HoaDon> list() {
        try {
            String txt_sql = "select * from quanlyhoadon";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery(txt_sql);

            ArrayList<HoaDon> list = new ArrayList<>();
            while (rs.next()){
                HoaDon h = new HoaDon(
                        rs.getInt("mahd"),
                        rs.getInt("manv"),
                        rs.getInt("makh"),
                        rs.getInt("masp"),
                        rs.getInt("soluong"),
                        rs.getDouble("giamgia"),
                        rs.getDate(rs.getString("ngayhd")),
                        rs.getDouble("thanhtien")
                );
                list.add(h);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void creat(HoaDon hoaDon) {
        String sql_txt = "insert into quanlyhoadon (manv,makh,masp,soluong,giamgia,ngayhd,thanhtien) values(?,?,?,?,?,?,?)";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,hoaDon.getManv().toString());
            stt.setString(2,hoaDon.getMakh().toString());
            stt.setString(3,hoaDon.getMasp().toString());
            stt.setString(4,hoaDon.getSoluong().toString());
            stt.setString(5,hoaDon.getGiamgia().toString());
            stt.setString(6,hoaDon.getNgayhd().toString());
            stt.setString(7,hoaDon.getThanhtien().toString());
            stt.execute();
        }catch (Exception e){}
    }

    @Override
    public void update(HoaDon hoaDon) {
        String sql_txt = "update quanlyhoadon set manv=?,makh=?,masp=?,soluong=?,giamgia=?,ngayhd=?,thanhtien=? Where mahd=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,hoaDon.getManv().toString());
            stt.setString(2,hoaDon.getMakh().toString());
            stt.setString(3,hoaDon.getMasp().toString());
            stt.setString(4,hoaDon.getSoluong().toString());
            stt.setString(5,hoaDon.getGiamgia().toString());
            stt.setString(6,hoaDon.getNgayhd().toString());
            stt.setString(7,hoaDon.getThanhtien().toString());
            stt.setString(8,hoaDon.getMahd().toString());
            stt.execute();
        }catch (Exception e){}
    }

    @Override
    public void delete(HoaDon hoaDon) {
        String sql_txt = "delete from quanlyhoadon where mahd=?";
        try {
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setInt(1,hoaDon.getMahd());
            stt.execute();
        }catch (Exception e){}
    }
}
