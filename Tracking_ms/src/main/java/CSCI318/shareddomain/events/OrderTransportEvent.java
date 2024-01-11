package CSCI318.shareddomain.events;
    
public class OrderTransportEvent {
    OrderTransportEventData orderTransportEventData;

    public OrderTransportEvent() {}

    public OrderTransportEvent(OrderTransportEventData orderTransportEventData) {
        this.orderTransportEventData =  orderTransportEventData;
    }

    public void setOrderTransportEventData(OrderTransportEventData orderTransportEventData) {
        this.orderTransportEventData =  orderTransportEventData;
    }

    public OrderTransportEventData getOrderTransportEventData() {
        return orderTransportEventData;
    }
}