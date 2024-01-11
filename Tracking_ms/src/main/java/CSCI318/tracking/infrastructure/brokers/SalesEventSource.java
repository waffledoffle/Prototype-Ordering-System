package CSCI318.tracking.infrastructure.brokers;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SalesEventSource {

    String ORDER_INPUT = "orderTransportChannel";

    @Input(ORDER_INPUT)
    SubscribableChannel orderChannel();

}
