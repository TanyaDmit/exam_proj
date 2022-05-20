package com.fintech.examproj.repository.notification;

import com.fintech.examproj.entity.PostalNotification;
import com.fintech.examproj.entity.PostalPackage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalNotificationRowMapper implements RowMapper<PostalNotification> {
    @Override
    public PostalNotification mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostalNotification postalNotification = new PostalNotification();
        postalNotification.setIdNotification(rs.getLong("id_notification"));
        postalNotification.setNumberPackage(rs.getLong("num_package"));
        postalNotification.setStatus(rs.getString("status"));
        postalNotification.setTextMessage(rs.getString("text_message"));
        postalNotification.setDateChangeStatus((rs.getString("date_change_status")));
        return postalNotification;
    }
}
