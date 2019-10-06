package com.school.school.fallbackslalu;

import com.school.school.service.GalleryFeign;
import org.springframework.web.bind.annotation.PathVariable;

public class GalleryFeignFallback implements GalleryFeign {
    @Override
    public String findByName(@PathVariable(value = "name") String name) {

        System.out.println("In fallbackkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        return "galleryService is down";
    }
}
