package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.service.PostalClientService;
import com.fintech.examproj.service.PostalOfficeService;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostalOfficeController {
    private final PostalOfficeService postalOfficeService;
    private static final Logger log = Logger.getLogger(PostalOfficeController.class);
    @Autowired
    public PostalOfficeController(PostalOfficeService postalOfficeService) {
        this.postalOfficeService = postalOfficeService;
    }

    @PostMapping("/save")
    public int save(@Validated @RequestBody PostalOffice postalOffice) {
        log.info("save postalOffice in table offices: " + postalOffice);
        return postalOfficeService.save(postalOffice);
    }

    @GetMapping("/findall")
    public void findAll(){
        List<PostalOffice> postalOffices = postalOfficeService.findALL();
        for(int i = 0; i < postalOffices.size(); i++){
            log.info("office: " + postalOffices.get(i));
        }
    }

    @GetMapping("/writeinfile")
    public void writePostalPackage(){
        postalOfficeService.writePostalOffice();
    }
}
