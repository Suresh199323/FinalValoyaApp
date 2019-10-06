package com.example.gallary.gallery.dao;

import com.example.gallary.gallery.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {

    Student findByEmail(String emial);
}
