package com.fintech.examproj.repository.notification;

import com.fintech.examproj.entity.PostalNotification;
import com.fintech.examproj.repository.postalpackage.PostalPackageRepositoryImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepositoryImpl implements  NotificationRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger log = Logger.getLogger(PostalPackageRepositoryImpl.class);
    @Override
    public int save(PostalNotification postalNotification) {
        log.info("insert into table packages: " + postalNotification);
        return jdbcTemplate.update("INSERT INTO messages" +
                        "(num_package, text_message, status) values (?::int, ?, 'new_message')",
                postalNotification.getNumberPackage(),
                postalNotification.getTextMessage());
    }

    @Override
    public int delete(long id) {
        log.info("delete notification from table messages");
        return jdbcTemplate.update("DELETE FROM messages where id_message = ? ",id);
    }

    @Override
    public List<PostalNotification> findALL() {
        log.info("find all data in table messages ");
        return jdbcTemplate.query("SELECT * FROM messages", new PostalNotificationRowMapper());
    }

    public List<PostalNotification> findALLStatus() {
        log.info("find all data in table messages with status = new");
        return jdbcTemplate.query("SELECT * FROM messages" +
                "where status = 'new_message'", new PostalNotificationRowMapper());
    }

    public int changeStatus(PostalNotification postalNotification){
        log.info("change status of message from new to delivered");
        return jdbcTemplate.update("update messages" +
                "set(status) = (?)" +
                "where id_message = ?",
                postalNotification.getIdNotification(),
                postalNotification.getStatus());
    }
}
