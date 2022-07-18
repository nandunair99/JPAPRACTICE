package com.narola.spring;

import com.narola.spring.Repository.CustomerRepository;
import com.narola.spring.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class MedicineController {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MedicineRepository medicineRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping("/insertMedicine")
    public ResponseEntity<String> insertMedicine() {

        for (int i = 1; i <= 4; i++) {
            Category category = new Category();
            category.setCategoryName("category" + i);
            for (int j = 1; j <= 2; j++) {
                Medicine medicine = new Medicine();
                medicine.setMedicineName("med " + j + "cat " + i);
                medicine.setCreatedOn(Timestamp.from(Instant.now()));
                medicine.setUpdatedOn(Timestamp.from(Instant.now()));
                medicine.setMfgDate(Date.valueOf(LocalDate.now()));
                medicine.setExpDate(Date.valueOf(LocalDate.now()));
                medicine.setCategory(category);
                medicineRepository.save(medicine);
            }

        }

        return ResponseEntity.ok().build();
    }


    @Transactional
    @PostMapping("/getMedicineByNameLike")
    public ResponseEntity<String> getMedicine1() {
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByMedicineNameLike("%med 1%");
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok("added");
    }

    @Transactional
    @PostMapping("/getMedicineByCategoryId")
    public ResponseEntity<String> getMedicine2() {
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByCategoryCategoryID(1);
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok("added");
    }

    @Transactional
    @PostMapping("/getMedicineByIdAndCategoryID")
    public ResponseEntity<List<Medicine>> getMedicine4(Integer medId,Integer catId) {
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByMedicineIdAndCategoryCategoryID2(1,1);
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getMedicineByIdOrCategoryID")
    public ResponseEntity<List<Medicine>> getMedicine5(Integer medId,Integer catId) {
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByMedicineIdOrCategoryCategoryID(1,1);
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getMedicineByMfgDateBetween")
    public ResponseEntity<List<Medicine>> getMedicine6(String startDate,String endDate) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByMfgDateBetween2(LocalDate.parse(startDate, dtf),LocalDate.parse(endDate, dtf));
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getExpiredMedicine")
    public ResponseEntity<List<Medicine>> getMedicine7() {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByExpDateGreaterThan2(LocalDate.now());
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getByCategoryIDIsNull")
    public ResponseEntity<List<Medicine>> getMedicine8() {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByCategoryCategoryIDIsNull2();
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getByMedicineNameStartingWith")
    public ResponseEntity<List<Medicine>> getMedicine9(String name) {
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByMedicineNameStartingWith2(name);
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getByMedicineNameNotStartingWith")
    public ResponseEntity<List<Medicine>> getMedicine10(String name) {
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findByMedicineNameNotLike2(name);
        for (Medicine med : medicineList) {
            System.out.println(med);
        }
        return ResponseEntity.ok().body(medicineList);
    }

    @Transactional
    @PostMapping("/getMedicine3")
    public ResponseEntity<String> getMedicine3() {


        List<Medicine> medicineList2 = (List<Medicine>) medicineRepository.getMedicineAndCategory();
        for (Medicine med2 : medicineList2) {
            System.out.println(med2);
        }
        return ResponseEntity.ok("added");
    }

    @Transactional
    @PostMapping("/getCustomers")
    public ResponseEntity<String> getCustomers() {


        List<Customer> customers = (List<Customer>) customerRepository.getCustomers();
        String customerList="";
        for (Customer customer : customers) {
            customerList=customerList.concat(customer.getCustomerId().getName()+", ");
        }
        return ResponseEntity.ok(customerList);
    }



}

