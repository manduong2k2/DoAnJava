package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ChiTietTheTrang_ThucPham")
public class CTTheTrang_ThucPham {
    @EmbeddedId
    private ChiTietTheTrangThucPhamId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maThucPham")
    private ThucPham thucPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maTheTrang")
    private TheTrang theTrang;

    @Column(name = "HamLuongHangNgay")
    private float hamLuongHangNgay;

    public ChiTietTheTrangThucPhamId getId() {
        return id;
    }

    public void setId(ChiTietTheTrangThucPhamId id) {
        this.id = id;
    }

    public ThucPham getThucPham() {
        return thucPham;
    }

    public void setThucPham(ThucPham thucPham) {
        this.thucPham = thucPham;
    }

    public TheTrang getTheTrang() {
        return theTrang;
    }

    public void setTheTrang(TheTrang theTrang) {
        this.theTrang = theTrang;
    }

    public float getHamLuongHangNgay() {
        return hamLuongHangNgay;
    }

    public void setHamLuongHangNgay(float hamLuongHangNgay) {
        this.hamLuongHangNgay = hamLuongHangNgay;
    }
}
