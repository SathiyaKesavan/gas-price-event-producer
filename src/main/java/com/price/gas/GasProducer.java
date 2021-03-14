package com.price.gas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.price.gas.model.GasPrices;


@Component
public class GasProducer {

    private final KafkaTemplate<String, GasPrices> kafkaTemplate;


    @Value("${cloudkarafka.topic}")
    private String topic;
    


    GasProducer(KafkaTemplate<String, GasPrices> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    //sending a custom message to kafka
    public void send(GasPrices message) {
        this.kafkaTemplate.send(topic, message);
        System.out.println("Sent sample message [" + message.getResult().get(0).getName() + " " + message.getResult().get(0).getGasoline()+ "]" );
    }

}
