package CSCI318.salesms.infrastructure.brokers;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SalesEventSource {

    @Output("OrderTransportChannel")
    MessageChannel orderTransport();
}
