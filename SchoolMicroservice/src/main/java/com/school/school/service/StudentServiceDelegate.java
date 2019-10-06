/*
package com.school.school.service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


public class StudentServiceDelegate {

    @Autowired
    GalleryFeign galleryFeign;

    @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
    public String callStudentServiceAndGetData(String name) {

        System.out.println("Getting School details for " + name);


        return  galleryFeign.findByName(name);
    }


    private String callStudentServiceAndGetData_Fallback(String schoolname) {

        System.out.println("gallery Service is down!!! fallback route enabled...");

        return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. " +
                " Service will be back shortly - " + new Date();
    }



}
*/
