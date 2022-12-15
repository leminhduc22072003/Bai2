package JP2.SuperMarket;

import java.util.ArrayList;

public interface ISanPhamInterface {
    ArrayList<SanPham> list1();
    void create(SanPham sanPham);
    void update(SanPham sanPham);
    void delete(SanPham sanPham);

}
