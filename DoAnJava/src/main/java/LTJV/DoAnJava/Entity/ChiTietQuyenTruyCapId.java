package LTJV.DoAnJava.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietQuyenTruyCapId implements Serializable {


    @Column(name = "MaNguoiDung")
    private int maNguoiDung;

    @Column(name = "MaQuyenTruyCap")
    private int maQuyenTruyCap;

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public int getMaQuyenTruyCap() {
        return maQuyenTruyCap;
    }

    public void setMaQuyenTruyCap(int maQuyenTruyCap) {
        this.maQuyenTruyCap = maQuyenTruyCap;
    }
}
