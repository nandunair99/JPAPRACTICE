package com.narola.spring.Repository;

import com.narola.spring.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

    List<Medicine> findByMedicineName(String medicineName);
    List<Medicine> findByMedicineNameLike(String medicineName);
    List<Medicine> findByCategoryCategoryID(int catId);
    List<Medicine> findByMedicineIdAndCategoryCategoryID(int medId,int catId);
    List<Medicine> findByMedicineIdOrCategoryCategoryID(int medId,int catId);
    List<Medicine> findByMfgDateBetween(LocalDate startDate,LocalDate endDate);
    List<Medicine>  findByExpDateGreaterThan(LocalDate date);
    List<Medicine> findByCategoryCategoryIDIsNull();
    List<Medicine> findByMedicineNameStartingWith(String name);
    List<Medicine> findByMedicineNameNotLike(String name);

    @Query("select m from Medicine m inner join m.category where m.medicineId=:medId and m.category.categoryID=:catId")
    List<Medicine> findByMedicineIdAndCategoryCategoryID2(@Param("medId") int medId, @Param("catId") int catId);
    @Query("select m from Medicine m inner join m.category where m.medicineId=:medId or m.category.categoryID=:catId")
    List<Medicine> findByMedicineIdOrCategoryCategoryID2(@Param("medId") int medId, @Param("catId") int catId);
    @Query("select m from Medicine m where m.mfgDate between :startDate and :endDate")
    List<Medicine> findByMfgDateBetween2(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);

    @Query("select m from Medicine m where m.expDate > :date")
    List<Medicine>  findByExpDateGreaterThan2(@Param("date") LocalDate date);

    @Query("select m from Medicine m where m.category is null")
    List<Medicine> findByCategoryCategoryIDIsNull2();
    @Query("select m from Medicine m where m.medicineName like :name%")
    List<Medicine> findByMedicineNameStartingWith2(@Param("name") String name);
    @Query("select m from Medicine m where m.medicineName not like :name")
    List<Medicine> findByMedicineNameNotLike2(@Param("name") String name);
    @Query("select m from Medicine m inner join m.category")
    List<Medicine> getMedicineAndCategory();

}
