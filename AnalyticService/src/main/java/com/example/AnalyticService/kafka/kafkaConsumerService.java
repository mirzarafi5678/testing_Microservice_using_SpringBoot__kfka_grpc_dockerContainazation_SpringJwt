package com.example.AnalyticService.kafka;


import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class kafkaConsumerService {
    private static final Logger log = LoggerFactory.getLogger(
            kafkaConsumerService.class);
    @KafkaListener (topics= "patient-topic",groupId = "analytic-group")
    public void consumerEvent (byte[] event ){
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("Received Patient Event: [PatientId={},PatientName={},PatientEmail={}]",
                    patientEvent.getPatientId(),
                    patientEvent.getName(),
                    patientEvent.getEmail());
        }catch (InvalidProtocolBufferException e) {
            log.error("Error deserializing event {}", e.getMessage());
        }

    }

}
