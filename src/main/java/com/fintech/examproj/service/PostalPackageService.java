package com.fintech.examproj.service;

import com.fintech.examproj.controller.FileController;
import com.fintech.examproj.controller.PostalPackagesController;
import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalPackage;
import com.fintech.examproj.repository.postalpackage.PostalPackageRepositoryImpl;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostalPackageService {
    private final PostalPackageRepositoryImpl postalPackageRepository;
    private final FileController fileController;
    private static final Logger log = Logger.getLogger(PostalPackagesController.class);

    public int save(PostalPackage postalPackage) {
        return postalPackageRepository.save(postalPackage);
    }
    public int delete(long id) {
        return postalPackageRepository.delete(id);
    }
    public List<PostalPackage> findALL() {
//        log.info();
        return postalPackageRepository.findALL();
    }

    public void writePostalPackage(){
        fileController.writePostalPackage(postalPackageRepository.findALL());
    }
}
