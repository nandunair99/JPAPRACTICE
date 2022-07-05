import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerID implements Serializable {
    private String name;
    private String phoneNo;

}
