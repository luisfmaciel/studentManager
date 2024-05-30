package br.edu.infnet.studentmanager.service;

import br.edu.infnet.studentmanager.model.Course;
import br.edu.infnet.studentmanager.model.Student;
import br.edu.infnet.studentmanager.repository.CourseRepository;
import br.edu.infnet.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        student.addCourse(course);
        return studentRepository.save(student);
    }

    public void unenrollStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        student.removeCourse(course);
        studentRepository.save(student);
    }
}
