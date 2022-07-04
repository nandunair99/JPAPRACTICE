import javax.persistence.*;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medId")
    private int medicineId;
    @Column(name = "medName", unique = true, nullable = false)
    private String medicineName;
    @ManyToOne
    private Category category;
    //private InputStream picture;
    @Temporal(TemporalType.DATE)
    @Column(name = "mfgDate", nullable = false)
    private LocalDate mfgDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "expDate", nullable = false)
    private LocalDate expDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false)
    private LocalDateTime createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedOn", nullable = false)
    private LocalDateTime updatedOn;

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
