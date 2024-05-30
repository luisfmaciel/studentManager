package br.edu.infnet.studentmanager.controller;

import br.edu.infnet.studentmanager.model.Student;
import br.edu.infnet.studentmanager.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<Student> enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        Student enrolledStudent = enrollmentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(enrolledStudent);
    }

    @PostMapping("/unenroll")
    public  ResponseEntity<Student> unenrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        enrollmentService.unenrollStudentFromCourse(studentId, courseId);
        return ResponseEntity.noContent().build();
    }
}
