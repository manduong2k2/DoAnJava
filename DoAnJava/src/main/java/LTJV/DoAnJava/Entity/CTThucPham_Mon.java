package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ChiTietMon_ThucPham")

public class CTThucPham_Mon {
    @EmbeddedId
    private ChiTietMonThucPhamId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maMon")
    private Mon mon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maThucPham")
    private ThucPham thucPham;

    @Column(name = "HamLuongThucPham")
    private float hamLuongThucPham;

    public ChiTietMonThucPhamId getId() {
        return id;
    }

    public void setId(ChiTietMonThucPhamId id) {
        this.id = id;
    }

    public Mon getMon() {
        return mon;
    }

    public void setMon(Mon mon) {
        this.mon = mon;
    }

    public ThucPham getThucPham() {
        return thucPham;
    }

    public void setThucPham(ThucPham thucPham) {
        this.thucPham = thucPham;
    }

    public float getHamLuongThucPham() {
        return hamLuongThucPham;
    }

    public void setHamLuongThucPham(float hamLuongThucPham) {
        this.hamLuongThucPham = hamLuongThucPham;
    }
}
