package LTJV.DoAnJava.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietMonThucPhamId implements Serializable {

    @Column(name = "MaMon")
    private int maMon;

    @Column(name = "MaThucPham")
    private int maThucPham;

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public int getMaThucPham() {
        return maThucPham;
    }

    public void setMaThucPham(int maThucPham) {
        this.maThucPham = maThucPham;
    }
}
