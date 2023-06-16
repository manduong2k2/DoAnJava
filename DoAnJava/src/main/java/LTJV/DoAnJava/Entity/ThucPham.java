package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "THUCPHAM")
public class ThucPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThucPham")
    private int maThucPham;

    @Column(name = "TenThucPham")
    private String tenThucPham;

    @Column(name = "ThongTinThucPham")
    private String thongTinThucPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoaiThucPham")
    private LoaiThucPham loaiThucPham;

    @Column(name = "AnhThucPham")
    private String anhThucPham;

    @Column(name = "CaLoThucPham")
    private float caLoThucPham;

    public int getMaThucPham() {
        return maThucPham;
    }

    public void setMaThucPham(int maThucPham) {
        this.maThucPham = maThucPham;
    }

    public String getTenThucPham() {
        return tenThucPham;
    }

    public void setTenThucPham(String tenThucPham) {
        this.tenThucPham = tenThucPham;
    }

    public String getThongTinThucPham() {
        return thongTinThucPham;
    }

    public void setThongTinThucPham(String thongTinThucPham) {
        this.thongTinThucPham = thongTinThucPham;
    }

    public LoaiThucPham getLoaiThucPham() {
        return loaiThucPham;
    }

    public void setLoaiThucPham(LoaiThucPham loaiThucPham) {
        this.loaiThucPham = loaiThucPham;
    }

    public String getAnhThucPham() {
        return anhThucPham;
    }

    public void setAnhThucPham(String anhThucPham) {
        this.anhThucPham = anhThucPham;
    }

    public float getCaLoThucPham() {
        return caLoThucPham;
    }

    public void setCaLoThucPham(float caLoThucPham) {
        this.caLoThucPham = caLoThucPham;
    }
}
