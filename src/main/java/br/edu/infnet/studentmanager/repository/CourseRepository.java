package br.edu.infnet.studentmanager.repository;

import br.edu.infnet.studentmanager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
