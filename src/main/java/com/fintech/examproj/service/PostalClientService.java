package com.fintech.examproj.service;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.repository.postalclient.PostalClientRepositoryImpl;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostalClientService {
    private final PostalClientRepositoryImpl postalClientRepository;

    public int save(PostalClient postalClient) {
        return postalClientRepository.save(postalClient);
    }
    public int delete(long id) {
        return postalClientRepository.delete(id);
    }
    public List<PostalClient> findALL() {
        return postalClientRepository.findALL();
    }
}
