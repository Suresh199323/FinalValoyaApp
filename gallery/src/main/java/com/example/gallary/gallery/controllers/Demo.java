package com.example.gallary.gallery.controllers;

import com.example.gallary.gallery.domain.Student;
import com.example.gallary.gallery.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/rest/demo")
public class Demo
 {
     @Autowired
     StudentService studentService;

     @Autowired
     Environment environment;
     @RequestMapping(value = "/echoStudentName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
     public String echoStudentName(@PathVariable(name = "name") String name)
     {
	 System.out.println("Inside MyRestController::backend...");
 
        String serverPort = environment.getProperty("local.server.port");
 
        System.out.println("Port : " + serverPort);

         return "hello";
     }



     @RequestMapping(value = "/getStudentDetails/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public Student getStudentDetails(@PathVariable(name = "email") String email)
     {
        Student student= studentService.findByEmail(email);



		 //         String serverPort = environment.getProperty("local.server.port");
 
  //      System.out.println("Port : " + serverPort);
         return student;
     }

}