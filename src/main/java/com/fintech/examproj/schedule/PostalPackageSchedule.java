package com.fintech.examproj.schedule;

import com.fintech.examproj.controller.PostalPackagesController;
import com.fintech.examproj.service.PostalPackageService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component
public class PostalPackageSchedule {
    private static final Logger log = Logger.getLogger(PostalPackageSchedule.class);
    private PostalPackageService postalPackageService;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void sendPackages(){
        int counter = 0;
        boolean flagSend = false;
        System.out.println("hello 1");
        LocalDateTime ndt = LocalDateTime.now();
        log.info("The time is now " + dateTimeFormatter.format(ndt) + "\n");
        flagSend = postalPackageService.sendPackage();
        if(flagSend){
            counter++;
            flagSend = false;
        } else {
            counter = 0;
        }
        if(counter == 5){
            log.info("STOP. ALLE PACKAGES SENT " + dateTimeFormatter.format(ndt) + "\n");
        }
    }
}
