package com.example23.demo.controller;
import com.example23.demo.dto.PatienRequestDto;
import com.example23.demo.dto.PatientRespondDto;
import com.example23.demo.dto.Validators.CreatePatientValidationGroup;
import com.example23.demo.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Controller", description = "APIs for managing patients")
public class patientController {
    @Autowired
    private  PatientService  service ;

    @GetMapping
    @Operation(summary = "Get all patients", description = "Retrieve a list of all patients")
    public ResponseEntity<List<PatientRespondDto>> getPatients(){
        List<PatientRespondDto> patients = service.getPatients();
        return ResponseEntity.ok().body(patients);

    }

   @PostMapping
   @Operation(summary = "Create a new patient", description = "Create a new patient with the provided details")
    public ResponseEntity<PatientRespondDto> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class})  @RequestBody PatienRequestDto patienRequestDtos){
        PatientRespondDto newPatient = service.createPatient(patienRequestDtos);
        return ResponseEntity.ok().body(newPatient);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing patient", description = "Update the details of an existing patient by ID")
    public ResponseEntity<PatientRespondDto> updatePatient(@PathVariable("id") UUID id, @Validated({Default.class}) @RequestBody PatienRequestDto patienRequestDtos){
        PatientRespondDto updatedPatient = service.updatePatient(id, patienRequestDtos);
        return ResponseEntity.ok().body(updatedPatient);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient", description = "Delete an existing patient by ID")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") UUID id){
        service.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
