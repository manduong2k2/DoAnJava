package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "THETRANG")
public class TheTrang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTheTrang")
    private int maTheTrang;

    @Column(name = "TenTheTrang")
    private String tenTheTrang;

    @Column(name = "ThongTinTheTrang")
    private String thongTinTheTrang;

    @Column(name = "ThoiQuen")
    private String thoiQuen;

    public int getMaTheTrang() {
        return maTheTrang;
    }

    public void setMaTheTrang(int maTheTrang) {
        this.maTheTrang = maTheTrang;
    }

    public String getTenTheTrang() {
        return tenTheTrang;
    }

    public void setTenTheTrang(String tenTheTrang) {
        this.tenTheTrang = tenTheTrang;
    }

    public String getThongTinTheTrang() {
        return thongTinTheTrang;
    }

    public void setThongTinTheTrang(String thongTinTheTrang) {
        this.thongTinTheTrang = thongTinTheTrang;
    }

    public String getThoiQuen() {
        return thoiQuen;
    }

    public void setThoiQuen(String thoiQuen) {
        this.thoiQuen = thoiQuen;
    }
}
