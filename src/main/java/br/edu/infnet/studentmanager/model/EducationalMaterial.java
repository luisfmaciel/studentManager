package br.edu.infnet.studentmanager.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "educationalmaterials")
public class EducationalMaterial {
    @Id
    private String id;
    private String title;
    private String type;
    private String author;
    private String description;
}
