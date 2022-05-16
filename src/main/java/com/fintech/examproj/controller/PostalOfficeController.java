package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.service.PostalClientService;
import com.fintech.examproj.service.PostalOfficeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostalOfficeController {
    private final PostalOfficeService postalOfficeService;

    @Autowired
    public PostalOfficeController(PostalOfficeService postalOfficeService) {
        this.postalOfficeService = postalOfficeService;
    }

    @PostMapping("/save")
    public int save(@Validated @RequestBody PostalOffice postalOffice) {
        log.info("I did it: " + postalOffice);
        return postalOfficeService.save(postalOffice);
    }
}