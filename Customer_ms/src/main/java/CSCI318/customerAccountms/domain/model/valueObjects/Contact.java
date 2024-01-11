package CSCI318.customerAccountms.domain.model.valueObjects;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {
    
    private String name;
    private int phone;
    private String email;
    private String position;

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }
}
