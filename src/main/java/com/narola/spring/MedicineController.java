package com.narola.spring;

import com.narola.spring.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


@Controller
public class MedicineController {
//    @Autowired
//    EntityManagerFactory entityManagerFactory;

    @Autowired
    MedicineRepository medicineRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping("/insertMedicine")
    public ResponseEntity<String> insertMedicine() {

        for (int i = 1; i <= 4; i++) {
            Category category=new Category();
            category.setCategoryName("category"+i);
            for (int j = 1; j <= 2; j++) {
                Medicine medicine = new Medicine();
                medicine.setMedicineName("med "+j+"cat "+i);
                medicine.setCreatedOn(Timestamp.from(Instant.now()));
                medicine.setUpdatedOn(Timestamp.from(Instant.now()));
                medicine.setMfgDate(Date.valueOf(LocalDate.now()));
                medicine.setExpDate(Date.valueOf(LocalDate.now()));
                //medicine.setCategory(category);
                medicineRepository.save(medicine);
            }

        }

        return ResponseEntity.ok().build();
    }



    @Transactional
    @PostMapping("/getMedicine")
    public ResponseEntity<String> insertMedicine3() {

        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findAll();
        for(Medicine med:medicineList)
        {
            System.out.println(med);
        }
        return ResponseEntity.ok("added");
    }
}

