package LTJV.DoAnJava.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "PHAI")
public class Phai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhai")
    private int maPhai;

    @Column(name = "Phai")
    private String phai;

    public int getMaPhai() {
        return maPhai;
    }

    public void setMaPhai(int maPhai) {
        this.maPhai = maPhai;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }
}
