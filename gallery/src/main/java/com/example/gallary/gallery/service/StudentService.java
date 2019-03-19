package com.example.gallary.gallery.service;

import com.example.gallary.gallery.domain.Student;

public interface StudentService {
    Student findByEmail(String email);
}

