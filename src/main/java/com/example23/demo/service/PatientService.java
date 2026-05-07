package com.example23.demo.service;

import com.example23.demo.Mapper.patientMapper;
import com.example23.demo.dto.PatienRequestDto;
import com.example23.demo.dto.PatientRespoondDto;
import com.example23.demo.model.Patient;
import com.example23.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
 private PatientRepository patientRepository ;

 public PatientService(PatientRepository patientRepository){
     this.patientRepository= patientRepository;

 }
  public List<PatientRespoondDto> getPatients(){
     List <Patient> patients = patientRepository.findAll();

      return patients
              .stream().map(patient1 -> patientMapper.mapper(patient1)).toList();

  }
  public PatientRespoondDto createPatient(PatienRequestDto patienRequestDtos){
     Patient newpatient = patientRepository.save(patientMapper.toModel(patienRequestDtos));
     return patientMapper.mapper(newpatient);

  }
}
