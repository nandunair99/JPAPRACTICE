package com.narola.spring.Repository;

import com.narola.spring.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

    List<Medicine> findByMedicineName(String medicineName);
    List<Medicine> findByMedicineNameLike(String medicineName);

}
