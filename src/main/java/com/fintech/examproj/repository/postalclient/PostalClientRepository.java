package com.fintech.examproj.repository.postalclient;

import com.fintech.examproj.entity.PostalClient;

import java.util.List;

public interface PostalClientRepository {
    int save(PostalClient postalClient);
    int delete(long id);
    List<PostalClient> findALL();
}
