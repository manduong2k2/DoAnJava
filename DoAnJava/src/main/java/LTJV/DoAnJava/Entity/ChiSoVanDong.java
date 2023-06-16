package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CHISOVANDONG")
public class ChiSoVanDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChiSoVanDong")
    private int maChiSoVanDong;

    @Column(name = "ChiSoVanDong")
    private float chiSoVanDong;

    @Column(name = "TenChiSoVanDong")
    private String tenChiSoVanDong;

    public int getMaChiSoVanDong() {
        return maChiSoVanDong;
    }

    public void setMaChiSoVanDong(int maChiSoVanDong) {
        this.maChiSoVanDong = maChiSoVanDong;
    }

    public float getChiSoVanDong() {
        return chiSoVanDong;
    }

    public void setChiSoVanDong(float chiSoVanDong) {
        this.chiSoVanDong = chiSoVanDong;
    }

    public String getTenChiSoVanDong() {
        return tenChiSoVanDong;
    }

    public void setTenChiSoVanDong(String tenChiSoVanDong) {
        this.tenChiSoVanDong = tenChiSoVanDong;
    }
}
