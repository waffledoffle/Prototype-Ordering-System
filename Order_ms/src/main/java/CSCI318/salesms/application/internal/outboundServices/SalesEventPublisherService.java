package CSCI318.salesms.application.internal.outboundServices;

import CSCI318.salesms.infrastructure.brokers.SalesEventSource;
import CSCI318.shareddomain.events.SalesTransportEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@EnableBinding(SalesEventSource.class)
public class SalesEventPublisherService {
    SalesEventSource salesEventSource;

    public SalesEventPublisherService(SalesEventSource salesEventSource) {
        this.salesEventSource = salesEventSource;
    }

    @TransactionalEventListener
    public void handleSalesTransportEvent(SalesTransportEvent salesTransportEvent) {
        salesEventSource.orderTransport().send(MessageBuilder.withPayload(salesTransportEvent).build());
    }

}
