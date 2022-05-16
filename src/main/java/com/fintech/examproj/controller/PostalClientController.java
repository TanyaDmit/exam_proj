package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.service.PostalClientService;
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
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostalClientController {
    private final PostalClientService postalClientService;
    @Autowired
    public PostalClientController(PostalClientService postalClientService) {
        this.postalClientService = postalClientService;
    }

    @PostMapping("/save")
    public int save(@Validated @RequestBody PostalClient postalClient) {
        log.info("I did it: " + postalClient);
        return postalClientService.save(postalClient);
    }
}
