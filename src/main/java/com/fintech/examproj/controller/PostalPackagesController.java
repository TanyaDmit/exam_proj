package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.entity.PostalPackage;
import com.fintech.examproj.service.PostalPackageService;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/package", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostalPackagesController {

    private final PostalPackageService postalPackageService;
    private static final Logger log = Logger.getLogger(PostalPackagesController.class);
    @Autowired
    public PostalPackagesController(PostalPackageService postalPackageService) {
        this.postalPackageService = postalPackageService;
    }

    @PostMapping("/save")
    public int save(@Validated @RequestBody PostalPackage postalPackage) {
        log.info("save postalPackage in table packages: " + postalPackage);
        return postalPackageService.save(postalPackage);
    }

    @GetMapping("/findall")
    public void findAll(){
        List<PostalPackage> postalPackages = postalPackageService.findALL();
        for(int i = 0; i < postalPackages.size(); i++){
            log.info("package: " + postalPackages.get(i));
        }
    }

    @GetMapping("/writeinfile")
    public void writePostalPackage(){
        postalPackageService.writePostalPackage();
    }
}
