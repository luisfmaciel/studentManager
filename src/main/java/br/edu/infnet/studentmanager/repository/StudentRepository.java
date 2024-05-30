package br.edu.infnet.studentmanager.repository;

import br.edu.infnet.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
