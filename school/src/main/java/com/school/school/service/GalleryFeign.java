package com.school.school.service;


import com.school.school.fallbackslalu.GalleryFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



    @FeignClient(name="GALLERYSERVICE", fallback = GalleryFeignFallback.class)//Service Id of EmployeeSerach service
    public interface GalleryFeign {

        @RequestMapping(value = "/rest/demo/echoStudentName/{name}")
        public String findByName(@PathVariable(value = "name") String name);
    }



