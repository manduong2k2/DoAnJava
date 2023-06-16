package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "ChiTietQuyenTruyCap")
public class CTQuyenTruyCap {
    @EmbeddedId
    private ChiTietQuyenTruyCapId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maNguoiDung")
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maQuyenTruyCap")
    private QuyenTruyCap quyenTruyCap;

    @Column(name = "ThoiGian")
    private Date thoiGian;

    public ChiTietQuyenTruyCapId getId() {
        return id;
    }

    public void setId(ChiTietQuyenTruyCapId id) {
        this.id = id;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public QuyenTruyCap getQuyenTruyCap() {
        return quyenTruyCap;
    }

    public void setQuyenTruyCap(QuyenTruyCap quyenTruyCap) {
        this.quyenTruyCap = quyenTruyCap;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

}
