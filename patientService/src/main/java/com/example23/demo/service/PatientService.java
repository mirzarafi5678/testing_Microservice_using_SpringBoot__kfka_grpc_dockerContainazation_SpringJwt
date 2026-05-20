package com.example23.demo.service;

import com.example23.demo.Mapper.patientMapper;
import com.example23.demo.dto.PatienRequestDto;
import com.example23.demo.dto.PatientRespondDto;
import com.example23.demo.exception.EmailAlreadyExistsException;
import com.example23.demo.exception.PatienNotFoundException;
import com.example23.demo.model.Patient;
import com.example23.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
 private PatientRepository patientRepository ;

 public PatientService(PatientRepository patientRepository){



     this.patientRepository= patientRepository;

 }
  public List<PatientRespondDto> getPatients(){
     List <Patient> patients = patientRepository.findAll();

      return patients
              .stream().map(patient1 -> patientMapper.toDTO(patient1)).toList();

  }



  public PatientRespondDto createPatient(PatienRequestDto patienRequestDtos){
     if (patientRepository.existsByEmail(patienRequestDtos.getEmail())){
         throw new EmailAlreadyExistsException("Email already exists"+ patienRequestDtos.getEmail());
     }

     Patient newpatient = patientRepository.save(patientMapper.toModel(patienRequestDtos));
     return patientMapper.toDTO(newpatient);

  }


  public PatientRespondDto updatePatient(UUID id, PatienRequestDto patientReqDto){
    Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatienNotFoundException("patient id not found: "+ id));

      if (patientRepository.existsByEmailAndIdNot(patientReqDto.getEmail(),id)){
          throw new EmailAlreadyExistsException("Email already exists"+ patientReqDto.getEmail());
      }


//      Optional<Patient> existingPatient =
//              patientRepository.findByEmail(patientReqDto.getEmail());
//
//      if (existingPatient.isPresent() &&
//              !existingPatient.get().getId().equals(id)) {
//
//          throw new EmailAlreadyExistsException(
//                  "Email already exists: " + patientReqDto.getEmail());
//      }

    patient.setName(patientReqDto.getName());
    patient.setEmail(patientReqDto.getEmail());
    patient.setAddress(patientReqDto.getAddress());
    patient.setDateOfBirth(LocalDate.parse(patientReqDto.getDateOfBirth()));
    Patient updatedPatient = patientRepository.save(patient);


    return patientMapper.toDTO(patient);

  }
  public void deletePatient(UUID id){
     patientRepository.deleteById(id);
  }

}
