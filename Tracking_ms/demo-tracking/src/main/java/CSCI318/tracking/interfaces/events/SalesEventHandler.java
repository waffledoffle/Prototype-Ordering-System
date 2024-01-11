package CSCI318.tracking.interfaces.events;

import CSCI318.shareddomain.events.OrderTransportEvent;
import CSCI318.tracking.infrastructure.brokers.SalesEventSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * Event Handler for the Cargo Routed Event that the Tracking Bounded Context is interested in
 */
@Service
@EnableBinding(SalesEventSource.class)
public class SalesEventHandler {

    @StreamListener(SalesEventSource.ORDER_INPUT)
    public void receiveEvent(OrderTransportEvent orderTransportEvent) {
        System.out.println("****READING FROM KAFKA TOPIC cargobookings: "+
                orderTransportEvent.getOrderTransportEventData().getProductName()+"****");
    }
}