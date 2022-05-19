package com.fintech.examproj.repository.notification;

import com.fintech.examproj.entity.PostalNotification;
import com.fintech.examproj.entity.PostalPackage;

import java.util.List;

public interface NotificationRepository {
    int save(PostalNotification postalNotification);
    int delete(long id);
    List<PostalNotification> findALL();
}
