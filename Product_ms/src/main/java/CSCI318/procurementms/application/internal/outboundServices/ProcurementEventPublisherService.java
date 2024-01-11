package CSCI318.procurementms.application.internal.outboundServices;

import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import CSCI318.procurementms.infrastructure.brokers.ProcurementStockEventSource;
import CSCI318.shareddomain.events.ProcurementStockEvent;

@Service
@EnableBinding(ProcurementStockEventSource.class)
public class ProcurementEventPublisherService {
    ProcurementStockEventSource procurementStockEventSource;

    public ProcurementEventPublisherService(ProcurementStockEventSource procurementStockEventSource){ 
        this.procurementStockEventSource = procurementStockEventSource;
    }

    @TransactionalEventListener
    public void handleProcurementStockEvent(ProcurementStockEvent procurementStockEvent) {
        procurementStockEventSource.procurementChannel().send(MessageBuilder.withPayload(procurementStockEvent).build());
    }
}
