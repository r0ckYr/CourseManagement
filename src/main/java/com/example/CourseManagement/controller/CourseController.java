package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.Course;
import com.example.CourseManagement.model.CourseInstance;
import com.example.CourseManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/instances")
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        CourseInstance savedInstance = courseService.createCourseInstance(courseInstance);
        return new ResponseEntity<>(savedInstance, HttpStatus.CREATED);
    }

    @GetMapping("/instances/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseService.getCourseInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> getInstanceByYearSemesterAndCourseId(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        CourseInstance instance = courseService.getCourseInstanceByYearSemesterAndCourseId(year, semester, courseId);
        return instance != null ? ResponseEntity.ok(instance) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<Void> deleteCourseInstance(
            @PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        courseService.deleteCourseInstance(year, semester, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}