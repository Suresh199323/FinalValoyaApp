package com.example.gallary.gallery.Impl;

import com.example.gallary.gallery.dao.StudentDao;
import com.example.gallary.gallery.domain.Student;
import com.example.gallary.gallery.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student findByEmail(String email) {
        return studentDao.findByEmail(email);
    }
}
