package com.example.CourseManagement.service;

import com.example.CourseManagement.model.Course;
import com.example.CourseManagement.model.CourseInstance;
import com.example.CourseManagement.repository.CourseInstanceRepository;
import com.example.CourseManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public CourseInstance getCourseInstanceByYearSemesterAndCourseId(int year, int semester, Long courseId) {
        return courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, courseId);
    }

    public void deleteCourseInstance(int year, int semester, Long courseId) {
        CourseInstance instance = courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, courseId);
        if (instance != null) {
            courseInstanceRepository.delete(instance);
        }
    }
}
