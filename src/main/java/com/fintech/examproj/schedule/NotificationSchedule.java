package com.fintech.examproj.schedule;

import com.fintech.examproj.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component
public class NotificationSchedule {
    private static final Logger log = Logger.getLogger(NotificationSchedule.class);
    private NotificationService notificationService;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 7000)
    public void sendNotification(){
        int counter = 0;
        boolean flagSend = false;
        System.out.println("hello 2");
        LocalDateTime ndt = LocalDateTime.now();
        log.info("The time is now " + dateTimeFormatter.format(ndt) + "\n");
        flagSend = notificationService.sendNotification();
        if(flagSend){
            counter++;
            flagSend = false;
        } else {
            counter = 0;
        }
        if(counter == 5){
            log.info("STOP. ALLE NOTIFICATIONS SENT " + dateTimeFormatter.format(ndt) + "\n");
        }
    }
}

