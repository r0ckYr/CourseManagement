package com.example.CourseManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
