package com.fintech.examproj.repository.postalpackage;

import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.entity.PostalPackage;

import java.util.List;

public interface PostalPackageRepository {
    int save(PostalPackage postalPackage);
    int delete(long id);
    List<PostalPackage> findALL();
    public List<PostalPackage> findALLStatus();
}
