package JP2.SuperMarket;

import java.util.ArrayList;

public interface QLHDInterface {
    ArrayList<HoaDon> list();
    void creat(HoaDon hoaDon);
    void update(HoaDon hoaDon);
    void delete(HoaDon hoaDon);
}
