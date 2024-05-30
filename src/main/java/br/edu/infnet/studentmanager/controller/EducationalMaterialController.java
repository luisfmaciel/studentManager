package br.edu.infnet.studentmanager.controller;

import br.edu.infnet.studentmanager.model.EducationalMaterial;
import br.edu.infnet.studentmanager.service.EducationalMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educationalMaterial")
public class EducationalMaterialController {
    @Autowired
    private EducationalMaterialService educationalMaterialService;

    @GetMapping
    public ResponseEntity<List<EducationalMaterial>> getAllTeachers() {
        List<EducationalMaterial> allSEducationalMaterial = educationalMaterialService.getAllEducationalMaterials();
        return allSEducationalMaterial.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(allSEducationalMaterial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationalMaterial> getTeacherById(@PathVariable String id) {
        return educationalMaterialService.getEducationalMaterialById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EducationalMaterial> createTeacher(@RequestBody EducationalMaterial educationalMaterial) {
        EducationalMaterial savedEducationalMaterial = educationalMaterialService.saveEducationalMaterial(educationalMaterial);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEducationalMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationalMaterial> updateTeacher(@PathVariable String id, @RequestBody EducationalMaterial educationalMaterial) {
        EducationalMaterial updatedEducationalMaterial = educationalMaterialService.updateEducationalMaterialById(id, educationalMaterial);
        return ResponseEntity.ok(updatedEducationalMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EducationalMaterial> deleteTeacherById(@PathVariable String id) {
        educationalMaterialService.deleteEducationalMaterialById(id);
        return ResponseEntity.noContent().build();
    }


}
