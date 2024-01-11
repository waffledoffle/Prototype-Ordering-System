package CSCI318.tracking.infrastructure.brokers;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public class ProcurementEventSource {
    
    String PRODUCT_INPUT = "productInputChannel";
    String SUPPLY_INPUT = "supplyInputChannel";

    /*@Input(PRODUCT_INPUT)
    SubscribableChannel productChannel();

    */
}
