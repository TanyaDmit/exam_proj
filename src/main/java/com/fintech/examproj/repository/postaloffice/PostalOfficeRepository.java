package com.fintech.examproj.repository.postaloffice;

import com.fintech.examproj.entity.PostalOffice;

import java.util.List;

public interface PostalOfficeRepository {
    int save(PostalOffice postalOffice);
    int delete(long id);
    List<PostalOffice> findALL();
}
