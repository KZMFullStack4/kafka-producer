package com.example.producer.service;

import com.example.producer.dto.CreatePersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class PersonService {
    private final KafkaTemplate<String, CreatePersonDTO> kafkaTemplate;

    public PersonService(KafkaTemplate<String, CreatePersonDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void create(CreatePersonDTO createPerson) {
        Message<CreatePersonDTO> message = MessageBuilder
                .withPayload(createPerson)
                .setHeader(KafkaHeaders.TOPIC, "test1")
                .setHeader(KafkaHeaders.PARTITION_ID, 1)
                .build();
        this.kafkaTemplate.send(message);
    }
}
