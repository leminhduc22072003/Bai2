package JP2.SuperMarket;

import java.util.ArrayList;

public interface INhanvienInterface {
    ArrayList<NhanVien> list();
    void create(NhanVien nhanvien);
    void update(NhanVien nhanvien);
    void delete(NhanVien nhanvien);
}
