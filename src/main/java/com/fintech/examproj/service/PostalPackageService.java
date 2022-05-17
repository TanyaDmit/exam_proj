package com.fintech.examproj.service;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalPackage;
import com.fintech.examproj.repository.postalpackage.PostalPackageRepositoryImpl;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostalPackageService {
    private final PostalPackageRepositoryImpl postalPackageRepository;
    public int save(PostalPackage postalPackage) {
        return postalPackageRepository.save(postalPackage);
    }
    public int delete(long id) {
        return postalPackageRepository.delete(id);
    }
    public List<PostalPackage> findALL() {
        return postalPackageRepository.findALL();
    }
}
