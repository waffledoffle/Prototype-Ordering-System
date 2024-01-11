package CSCI318.procurementms.domain.model.valueObjects;
import javax.persistence.Embeddable;

@Embeddable
public class ProductDetail {
    private String description;
    private String comment;

    public ProductDetail(){

    }

    public String getDescription() {
        return description;
    }

    public String getComment() {
        return comment;
    }
}
