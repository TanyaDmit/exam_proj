package com.fintech.examproj.service;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.repository.postaloffice.PostalOfficeRepositoryImpl;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostalOfficeService {
    private final PostalOfficeRepositoryImpl postalOfficeRepository;
    public int save(PostalOffice postalOffice) {
        return postalOfficeRepository.save(postalOffice);
    }
    public int delete(long id) {
        return postalOfficeRepository.delete(id);
    }
    public List<PostalOffice> findALL() {
        return postalOfficeRepository.findALL();
    }
}
