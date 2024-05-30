package br.edu.infnet.studentmanager.service;

import br.edu.infnet.studentmanager.model.EducationalMaterial;
import br.edu.infnet.studentmanager.repository.EducationalMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationalMaterialService {

    @Autowired
    private EducationalMaterialRepository educationalMaterialRepository;

    @Cacheable(value = "educationalMaterials")
    public List<EducationalMaterial> getAllEducationalMaterials() {
        return educationalMaterialRepository.findAll();
    }

    @Cacheable(value = "educationalMaterials", key = "#id")
    public Optional<EducationalMaterial> getEducationalMaterialById(String id) {
        return educationalMaterialRepository.findById(id);
    }

    public EducationalMaterial saveEducationalMaterial(EducationalMaterial educationalMaterial) {
        return educationalMaterialRepository.save(educationalMaterial);
    }

    public  EducationalMaterial updateEducationalMaterialById(String id, EducationalMaterial educationalMaterial) {
        Optional<EducationalMaterial> educationalMaterialtOptional = educationalMaterialRepository.findById(id);
        if (educationalMaterialtOptional.isPresent()) {
            educationalMaterial.setId(id);
            return educationalMaterialRepository.save(educationalMaterial);
        }
        return null;
    }

    public void deleteEducationalMaterialById(String id) {
        educationalMaterialRepository.deleteById(id);
    }
}
