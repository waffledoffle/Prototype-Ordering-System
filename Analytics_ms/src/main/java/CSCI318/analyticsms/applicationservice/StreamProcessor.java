package CSCI318.analyticsms.applicationservice;

import CSCI318.shareddomain.events.SalesTransportEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class StreamProcessor {
    @Bean
    public Consumer<KStream<String, SalesTransportEvent>> process() {
        return inputStream -> {
    
            KStream<String, Long> aggregatedStream = inputStream.map((key, value) -> {
                        String eventType = value.getSalesTransportEventData().getEventType();
                        return KeyValue.pair(eventType, 1L);
                    }).
                    groupByKey(Grouped.with(Serdes.String(), Serdes.Long())).
                    reduce(Long::sum).toStream();
    
            aggregatedStream.print(Printed.<String, Long>toSysOut().withLabel("Number of orders that have been created, shipped, and received"));
        };
    }
}