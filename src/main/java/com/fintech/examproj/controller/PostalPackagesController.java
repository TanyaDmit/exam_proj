package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.service.PostalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PostalPackagesController {

    private final PostalPackageService postalPackageService;
    @Autowired
    public PostalClientController(PostalClientService postalClientService) {
        this.postalPackageService = postalClientService;
    }

    @PostMapping("/save")
    public int save(@Validated @RequestBody PostalClient postalClient) {
        log.info("I did it: " + postalClient);
        return postalPackageService.save(postalClient);
    }
}
