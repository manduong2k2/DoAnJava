package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "THONGTIN")
public class ThongTin {
    @Id
    @Column(name = "MaNguoiDung")
    private int maNguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaChiSoVanDong")
    private ChiSoVanDong chiSoVanDong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhai")
    private Phai phai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTheTrang")
    private TheTrang theTrang;

    @Column(name = "Tuoi")
    private int tuoi;

    @Column(name = "CanNang")
    private int canNang;

    @Column(name = "ChieuCao")
    private int chieuCao;

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public ChiSoVanDong getChiSoVanDong() {
        return chiSoVanDong;
    }

    public void setChiSoVanDong(ChiSoVanDong chiSoVanDong) {
        this.chiSoVanDong = chiSoVanDong;
    }

    public Phai getPhai() {
        return phai;
    }

    public void setPhai(Phai phai) {
        this.phai = phai;
    }

    public TheTrang getTheTrang() {
        return theTrang;
    }

    public void setTheTrang(TheTrang theTrang) {
        this.theTrang = theTrang;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getCanNang() {
        return canNang;
    }

    public void setCanNang(int canNang) {
        this.canNang = canNang;
    }

    public int getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }
}
