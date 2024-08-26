package com.example.CourseManagement.repository;

import com.example.CourseManagement.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

    List<CourseInstance> findByYearAndSemester(int year, int semester);
    CourseInstance findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);
}
