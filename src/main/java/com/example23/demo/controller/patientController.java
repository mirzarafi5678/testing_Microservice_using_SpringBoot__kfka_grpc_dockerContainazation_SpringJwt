package com.example23.demo.controller;


import com.example23.demo.dto.PatienRequestDto;
import com.example23.demo.dto.PatientRespoondDto;
import com.example23.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class patientController {
    @Autowired
    private  PatientService  service ;

    @GetMapping
    public ResponseEntity<List<PatientRespoondDto>> getPatients(){
        List<PatientRespoondDto> patients = service.getPatients();
        return ResponseEntity.ok().body(patients);

    }

   @PostMapping
    public ResponseEntity<PatientRespoondDto> createPatient(@Valid  @RequestBody PatienRequestDto patienRequestDtos){
        PatientRespoondDto newPatient = service.createPatient(patienRequestDtos);
        return ResponseEntity.ok().body(newPatient);

    }


}
