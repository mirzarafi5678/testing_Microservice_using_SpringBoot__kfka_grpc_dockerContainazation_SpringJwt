package com.example23.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class kafkaConsumerService {

    @KafkaListener(topics = "patient-topic", groupId = "patient-group")
    public void consume(byte[] message) {

        try {
            PatientEvent event = PatientEvent.parseFrom(message);
            System.out.println("Patient ID: " + event.getPatientId());
            System.out.println("Name: " + event.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}