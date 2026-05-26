package com.example23.demo.kafka;

import com.example23.demo.model.Patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class kafkaProducerService {
    private static final Logger log = LoggerFactory.getLogger(
            kafkaProducerService.class);
    @Autowired
    private KafkaTemplate<String, byte[]>  kafkaTemplate;
    public void sendEvent(Patient patient){
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName().toString())
                .setEmail(patient.getEmail().toString())
                .setEventType("Patient_create")
                .build();

        try {
            kafkaTemplate.send("patient-topic", event.toByteArray());
        } catch (Exception e) {
            log.error("Error sending PatientCreated event: {}", event);
        }
    }


}
