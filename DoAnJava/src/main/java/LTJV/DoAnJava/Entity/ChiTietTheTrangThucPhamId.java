package LTJV.DoAnJava.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietTheTrangThucPhamId implements Serializable {


    @Column(name = "MaThucPham")
    private int maThucPham;

    @Column(name = "MaTheTrang")
    private int maTheTrang;

    public int getMaThucPham() {
        return maThucPham;
    }

    public void setMaThucPham(int maThucPham) {
        this.maThucPham = maThucPham;
    }

    public int getMaTheTrang() {
        return maTheTrang;
    }

    public void setMaTheTrang(int maTheTrang) {
        this.maTheTrang = maTheTrang;
    }
}
