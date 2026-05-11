package com.example23.demo.controller;


import com.example23.demo.dto.PatienRequestDto;
import com.example23.demo.dto.PatientRespondDto;
import com.example23.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class patientController {
    @Autowired
    private  PatientService  service ;

    @GetMapping
    public ResponseEntity<List<PatientRespondDto>> getPatients(){
        List<PatientRespondDto> patients = service.getPatients();
        return ResponseEntity.ok().body(patients);

    }

   @PostMapping
    public ResponseEntity<PatientRespondDto> createPatient(@Valid  @RequestBody PatienRequestDto patienRequestDtos){
        PatientRespondDto newPatient = service.createPatient(patienRequestDtos);
        return ResponseEntity.ok().body(newPatient);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientRespondDto> updatePatient(@PathVariable("id") UUID id, @Valid  @RequestBody PatienRequestDto patienRequestDtos){
        PatientRespondDto updatedPatient = service.updatePatient(id, patienRequestDtos);
        return ResponseEntity.ok().body(updatedPatient);
    }


}
