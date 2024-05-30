package br.edu.infnet.studentmanager.controller;

import br.edu.infnet.studentmanager.model.Student;
import br.edu.infnet.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllTeachers() {
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(allStudents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getTeacherById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> createTeacher(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateTeacher(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudentById = studentService.updateStudentById(id, student);
        return ResponseEntity.ok(updatedStudentById);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteTeacherById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

}
