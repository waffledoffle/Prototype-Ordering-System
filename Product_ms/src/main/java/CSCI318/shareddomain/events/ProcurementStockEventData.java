package CSCI318.shareddomain.events;
import java.time.LocalDateTime;



public class ProcurementStockEventData{
  
    private String eventName;
    private LocalDateTime time;
    private String productName;

    public ProcurementStockEventData(String eventName, LocalDateTime time, String productName) {
        this.eventName = eventName;
        this.time = time;
        this.productName = productName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String name) {
        eventName = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        productName = name;
    }

}