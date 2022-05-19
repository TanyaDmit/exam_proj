package com.fintech.examproj.service;

import com.fintech.examproj.controller.FileController;
import com.fintech.examproj.controller.PostalPackagesController;
import com.fintech.examproj.entity.PostalNotification;
import com.fintech.examproj.entity.PostalPackage;
import com.fintech.examproj.repository.notification.NotificationRepositoryImpl;
import com.fintech.examproj.repository.postalpackage.PostalPackageRepositoryImpl;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Data
public class NotificationService {
    private final NotificationRepositoryImpl notificationRepository;
    private final FileController fileController;
    private static final Logger log = Logger.getLogger(NotificationService.class);

    public int save(PostalNotification postalNotification) {
        return notificationRepository.save(postalNotification);
    }
    public int delete(long id) {
        return notificationRepository.delete(id);
    }

    public List<PostalNotification> findALL() {
        log.info("print all packages");
        return notificationRepository.findALL();
    }

    public void writeNotification(){
        fileController.writeNotification(notificationRepository.findALL());
    }

    public boolean sendNotification() {
        boolean flagStatus;
        List<PostalNotification> postalNotification = notificationRepository.findALLStatus();
        fileController.sendNotification(postalNotification);
        flagStatus = changeStatus(postalNotification);
        return flagStatus;
    }

    private boolean changeStatus(List<PostalNotification> postalNotification){
        if(postalNotification.size() == 0){
            return false;
        }
        for(int i = 0; i < postalNotification.size(); i++){
            notificationRepository.changeStatus(postalNotification.get(i));
        }
        return true;
    }
}
