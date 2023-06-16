package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "NGUOIDUNG")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNguoiDung")
    private int maNguoiDung;

    @Column(name = "TenNguoiDung")
    private String tenNguoiDung;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "Mail")
    private String mail;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "TrangThaiTaiKhoang")
    private boolean trangThaiTaiKhoang;

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean getTrangThaiTaiKhoang() {
        return trangThaiTaiKhoang;
    }

    public void setTrangThaiTaiKhoang(boolean trangThaiTaiKhoang) {
        this.trangThaiTaiKhoang = trangThaiTaiKhoang;
    }
}
