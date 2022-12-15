package JP2.SuperMarket;

import java.util.ArrayList;

public interface KhachHangInterface {
        ArrayList<KhachHang> list();
        void creat(KhachHang khachHang);
        void update(KhachHang khachHang);
        void delete(KhachHang khachHang);
}

