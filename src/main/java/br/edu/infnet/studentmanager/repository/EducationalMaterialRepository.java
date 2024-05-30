package br.edu.infnet.studentmanager.repository;

import br.edu.infnet.studentmanager.model.EducationalMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalMaterialRepository  extends MongoRepository<EducationalMaterial, String> {
}
