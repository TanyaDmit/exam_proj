package com.fintech.examproj.service;

import com.fintech.examproj.controller.FileController;
import com.fintech.examproj.controller.PostalPackagesController;
import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalNotification;
import com.fintech.examproj.entity.PostalPackage;
import com.fintech.examproj.repository.postalpackage.PostalPackageRepositoryImpl;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Data
public class PostalPackageService {
    private final PostalPackageRepositoryImpl postalPackageRepository;
    private final FileController fileController;
    private static final Logger log = Logger.getLogger(PostalPackageService.class);

    public int save(PostalPackage postalPackage) {
        return postalPackageRepository.save(postalPackage);
    }
    public int delete(long id) {
        return postalPackageRepository.delete(id);
    }
    public List<PostalPackage> findALL() {
        log.info("print all packages");
        return postalPackageRepository.findALL();
    }

    public void writePostalPackage(){
        fileController.writePostalPackage(postalPackageRepository.findALL());
    }

    private final NotificationService notificationService;
    public boolean sendPackage() {
        List<PostalPackage> postalPackages = postalPackageRepository.findALLStatus();
        if(postalPackages.size()==0){
            return false;
        }else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ndt = LocalDateTime.now();
            for (int i = 0; i < postalPackages.size(); i++) {
                LocalDateTime dateTime = LocalDateTime.parse(postalPackages.get(i).getDateChangeStatus(), dateTimeFormatter);
                int sec1 = ndt.getSecond();
                int sec2 = dateTime.getSecond();
                int myRand = (int) (Math.random() * 5);
                if (myRand == 3 || myRand == 5) {
                        postalPackages.get(i).setStatus("delivered_package");
                        postalPackages.get(i).setDateChangeStatus(ndt.format(dateTimeFormatter));
                        notificationService.save(new PostalNotification(
                                postalPackages.get(i).getIdPackage(), "the package delivered"));
                        log.info(postalPackages.get(i));
                } else {
                    postalPackages.get(i).setStatus("overdue_package");
                    postalPackages.get(i).setDateChangeStatus(ndt.format(dateTimeFormatter));
                    notificationService.save(new PostalNotification(
                            postalPackages.get(i).getIdPackage(), "the package overdue"));
                    log.info(postalPackages.get(i));
                }
            }
            postalPackageRepository.updateStatus(postalPackages);
            return true;
        }
    }
}
