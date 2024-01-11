package CSCI318.shareddomain.events;
import java.time.LocalDateTime;
    
public class OrderTransportEventData {
   
        
    private String eventType;
    private LocalDateTime time;
    private Long orderId;
    private Long customerId;
    private String productName;
    private int quantity;

    public OrderTransportEventData(String eventType, LocalDateTime timestamp, Long orderId, Long customerId, String productName, int quantity) {
        this.eventType = eventType;
        this.time = timestamp;
        this.orderId = orderId;
        this.customerId = customerId;
        this.productName = productName;
        this.quantity = quantity;
    }
    
    public String getEventType() {
        return eventType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
    
}

