package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.service.PostalClientService;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostalClientController {
    private final PostalClientService postalClientService;
    private static final Logger log = Logger.getLogger(PostalClientController.class);
    @Autowired
    public PostalClientController(PostalClientService postalClientService) {
        this.postalClientService = postalClientService;
    }

    @PostMapping("/save")
    public int save(@Validated @RequestBody PostalClient postalClient) {
        log.info("save postalClient in table clients: " + postalClient);
        return postalClientService.save(postalClient);
    }

    @GetMapping("/findall")
    public void findAll(){
        List<PostalClient> postalClients = postalClientService.findALL();
        for(int i = 0; i < postalClients.size(); i++){
            log.info("client: " + postalClients.get(i));
        }
    }

    @GetMapping("/writeinfile")
    public void writePostalClient(){
        postalClientService.writePostalClient();
    }
}
