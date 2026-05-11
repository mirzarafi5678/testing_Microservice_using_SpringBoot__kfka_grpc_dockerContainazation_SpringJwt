package com.example23.demo.Mapper;

import com.example23.demo.dto.PatienRequestDto;
import com.example23.demo.dto.PatientRespondDto;
import com.example23.demo.model.Patient;

import java.time.LocalDate;

public class patientMapper {
    public static PatientRespondDto toDTO(Patient patient){
        PatientRespondDto obj = new PatientRespondDto();
        obj.setAddress(patient.getAddress().toString());
        obj.setDateOfBirth(patient.getDateOfBirth().toString());
        obj.setId(patient.getId().toString());
        obj.setName(patient.getName().toString());
        obj.setEmail(patient.getEmail().toString());
        obj.setDateOfRegister(patient.getRegisteredDate().toString());
        return obj;
    }
    public static Patient toModel(PatienRequestDto patienRequestDto){
        Patient patient = new Patient();
        patient.setName(patienRequestDto.getName());
        patient.setEmail(patienRequestDto.getEmail());
        patient.setAddress(patienRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patienRequestDto.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patienRequestDto.getDateOfRegister()));
        return patient;
    }

}
