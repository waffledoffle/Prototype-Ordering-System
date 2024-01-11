package CSCI318.shareddomain.events;

public class ProcurementStockEvent {
    ProcurementStockEventData procurementStockEventData;

    public ProcurementStockEvent() {}

    public ProcurementStockEvent(ProcurementStockEventData procurementStockEventData) {
        this.procurementStockEventData = procurementStockEventData;
    }

    public void setProcurementStockEventData(ProcurementStockEventData procurementStockEventData) {
        this.procurementStockEventData = procurementStockEventData;
    }

    public ProcurementStockEventData getProcurementStockEventData() {
        return procurementStockEventData;
    }
}
