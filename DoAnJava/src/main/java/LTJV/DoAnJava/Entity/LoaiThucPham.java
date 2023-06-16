package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LOAITHUCPHAM")
public class LoaiThucPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoaiThucPham")
    private int maLoaiThucPham;

    @Column(name = "TenLoaiThucPham")
    private String tenLoaiThucPham;

    public int getMaLoaiThucPham() {
        return maLoaiThucPham;
    }

    public void setMaLoaiThucPham(int maLoaiThucPham) {
        this.maLoaiThucPham = maLoaiThucPham;
    }

    public String getTenLoaiThucPham() {
        return tenLoaiThucPham;
    }

    public void setTenLoaiThucPham(String tenLoaiThucPham) {
        this.tenLoaiThucPham = tenLoaiThucPham;
    }
}
