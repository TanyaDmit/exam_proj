package com.fintech.examproj.service;

import com.fintech.examproj.controller.FileController;
import com.fintech.examproj.controller.PostalPackagesController;
import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.repository.postalclient.PostalClientRepositoryImpl;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostalClientService {
    private final PostalClientRepositoryImpl postalClientRepository;
    private final FileController fileController;
    private static final Logger log = Logger.getLogger(PostalPackagesController.class);


    public int save(PostalClient postalClient) {
        return postalClientRepository.save(postalClient);
    }
    public int delete(long id) {
        return postalClientRepository.delete(id);
    }
    public List<PostalClient> findALL() {
        return postalClientRepository.findALL();
    }
    public void writePostalClient(){
        fileController.writePostalClient(postalClientRepository.findALL());
    }
}
