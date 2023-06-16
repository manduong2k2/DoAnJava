package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "QUYENTRUYCAP")
public class QuyenTruyCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaQuyenTruyCap")
    private int maQuyenTruyCap;

    @Column(name = "TenQuyenTruyCap")
    private String tenQuyenTruyCap;

    public int getMaQuyenTruyCap() {
        return maQuyenTruyCap;
    }

    public void setMaQuyenTruyCap(int maQuyenTruyCap) {
        this.maQuyenTruyCap = maQuyenTruyCap;
    }

    public String getTenQuyenTruyCap() {
        return tenQuyenTruyCap;
    }

    public void setTenQuyenTruyCap(String tenQuyenTruyCap) {
        this.tenQuyenTruyCap = tenQuyenTruyCap;
    }
}
