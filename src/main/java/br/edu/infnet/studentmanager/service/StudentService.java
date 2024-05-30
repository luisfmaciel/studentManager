package br.edu.infnet.studentmanager.service;

import br.edu.infnet.studentmanager.model.Student;
import br.edu.infnet.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Cacheable(value = "students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Cacheable(value = "students", key = "#id")
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public  Student updateStudentById(Long id, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            student.setId(id);
            student.setCourses(studentOptional.get().getCourses());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
