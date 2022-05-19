package com.fintech.examproj.service;

import com.fintech.examproj.controller.FileController;
import com.fintech.examproj.controller.PostalPackagesController;
import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.repository.postaloffice.PostalOfficeRepositoryImpl;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostalOfficeService {
    private final PostalOfficeRepositoryImpl postalOfficeRepository;
    private final FileController fileController;
    private static final Logger log = Logger.getLogger(PostalPackagesController.class);

    public int save(PostalOffice postalOffice) {
        return postalOfficeRepository.save(postalOffice);
    }
    public int delete(long id) {
        return postalOfficeRepository.delete(id);
    }
    public List<PostalOffice> findALL() {
        return postalOfficeRepository.findALL();
    }

    public void writePostalOffice(){
        fileController.writePostalOffice(postalOfficeRepository.findALL());
    }
}
