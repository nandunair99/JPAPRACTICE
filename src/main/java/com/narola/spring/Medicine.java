package com.narola.spring;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="medicinetbl")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medId")
    private int medicineId;
    @Column(name = "medName", unique = true, nullable = false)
    private String medicineName;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name="cat_Id",referencedColumnName = "catId")
    private Category category;

    @Temporal(TemporalType.DATE)
    @Column(name = "mfgDate", nullable = false)
    private Date mfgDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "expDate", nullable = false)
    private Date expDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false)
    private Timestamp createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedOn", nullable = false)
    private Timestamp updatedOn;

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

    public Date getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", mfgDate=" + mfgDate +
                ", expDate=" + expDate +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
