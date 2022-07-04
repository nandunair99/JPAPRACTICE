import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

            for (int i = 1; i <= 4; i++) {
                Category category = new Category();
                category.setCategoryName("category" + i);
                for (int j = 1; j <= 2; j++) {
                    Medicine medicine = new Medicine();
                    medicine.setMedicineName("cat" + i + ": medicine" + j);
                    medicine.setCategory(category);
                    medicine.setMfgDate(new Date(new java.util.Date().getTime()).toLocalDate());
                    medicine.setExpDate(new Date(new java.util.Date().getTime()).toLocalDate());
                    medicine.setCreatedOn(new Timestamp(new java.util.Date().getTime()).toLocalDateTime());
                    medicine.setUpdatedOn(new Timestamp(new java.util.Date().getTime()).toLocalDateTime());
                    entityManager.persist(medicine);
                }
                entityManager.persist(category);
            }


//            entityManager.merge(post);
////            entityManager.remove(post);
////            entityManager.detach(post);


            transaction.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }
}