package br.edu.infnet.studentmanager.service;

import br.edu.infnet.studentmanager.model.Course;
import br.edu.infnet.studentmanager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Cacheable(value = "courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Cacheable(value = "courses", key = "#id")
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            updatedCourse.setId(id);
            updatedCourse.setStudents(courseOptional.get().getStudents());
            return courseRepository.save(updatedCourse);
        }
        return null;
    }
}
