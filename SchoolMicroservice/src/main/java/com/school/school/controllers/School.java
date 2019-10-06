package com.school.school.controllers;



import com.school.school.service.GalleryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RefreshScope
public class School {

    @Autowired
    GalleryFeign galleryFeign;

        @RequestMapping(value = "/getSchoolDetails/{name}", method = RequestMethod.GET)
        public String getStudents(@PathVariable String name)
                        {


                            return galleryFeign.findByName(name);
        }


    }

