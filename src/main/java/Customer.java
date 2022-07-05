import javax.persistence.*;

@Entity
@Table(name="customertbl")
public class Customer {
    @EmbeddedId
    private CustomerID customerId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride( name = "street", column = @Column(name = "customer_street")),
            @AttributeOverride( name = "country", column = @Column(name = "customer_country"))
    })
    private Address address;

}
