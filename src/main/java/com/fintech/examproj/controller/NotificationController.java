package com.fintech.examproj.controller;

import com.fintech.examproj.entity.PostalNotification;
import com.fintech.examproj.entity.PostalPackage;
import com.fintech.examproj.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationController {
    private final NotificationService notificationService;
    private static final Logger log = Logger.getLogger(NotificationController.class);

    @Autowired
    public NotificationController(NotificationService notificationService){
        this.notificationService=notificationService;
    }

    @GetMapping("/findall")
    public void findAll(){
        List<PostalNotification> postalNotifications = notificationService.findALL();
        for(int i = 0; i < postalNotifications.size(); i++){
            log.info("package: " + postalNotifications.get(i));
        }
    }
}
