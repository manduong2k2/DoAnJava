package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "MON")
public class Mon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaMon")
    private int maMon;

    @Column(name = "TenMon")
    private String tenMon;

    @Column(name = "ThongTinMon")
    private String thongTinMon;

    @Column(name = "AnhMon")
    private String anhMon;

    @Column(name = "CaLoMon")
    private float caLoMon;

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getThongTinMon() {
        return thongTinMon;
    }

    public void setThongTinMon(String thongTinMon) {
        this.thongTinMon = thongTinMon;
    }

    public String getAnhMon() {
        return anhMon;
    }

    public void setAnhMon(String anhMon) {
        this.anhMon = anhMon;
    }

    public float getCaLoMon() {
        return caLoMon;
    }

    public void setCaLoMon(float caLoMon) {
        this.caLoMon = caLoMon;
    }
}
