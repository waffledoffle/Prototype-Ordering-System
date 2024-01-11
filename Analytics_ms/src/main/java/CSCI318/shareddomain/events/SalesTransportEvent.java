package CSCI318.shareddomain.events;

public class SalesTransportEvent {
    SalesTransportEventData salesTransportEventData;

    public SalesTransportEvent() {}

    public SalesTransportEvent(SalesTransportEventData salesTransportEventData) {
        this.salesTransportEventData =  salesTransportEventData;
    }

    public void setSalesTransportEventData(SalesTransportEventData salesTransportEventData) {
        this.salesTransportEventData =  salesTransportEventData;
    }

    public SalesTransportEventData getSalesTransportEventData() {
        return salesTransportEventData;
    }
}