import javax.persistence.*;

@Entity
@Table(name="customertbl")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerId")
    private int customerId;
    @Column(name="name",nullable = false)
    private String customerName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride( name = "street", column = @Column(name = "customer_street")),
            @AttributeOverride( name = "country", column = @Column(name = "customer_country"))
    })
    private Address address;

}
