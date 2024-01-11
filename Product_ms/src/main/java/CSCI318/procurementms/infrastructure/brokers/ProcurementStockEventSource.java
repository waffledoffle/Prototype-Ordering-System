package CSCI318.procurementms.infrastructure.brokers;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProcurementStockEventSource {
    
    @Output("ProcurementStockChannel")
    MessageChannel procurementChannel();
}
