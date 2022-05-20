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
    private static final Logger log = Logger.getLogger(NotificationRepositoryImpl.class);
    @Override
    public int save(PostalNotification postalNotification) {
        log.info("insert into table messages: " + postalNotification);
        return jdbcTemplate.update("INSERT INTO messages" +
                        "(num_package, text_message, status) values (?::int, ?, 'new_message')",
                postalNotification.getNumberPackage(),
                postalNotification.getTextMessage());
    }

    @Override
    public int delete(long id) {
//        log.info("delete notification from table messages");
//        return jdbcTemplate.update("DELETE FROM messages where id_notification = ? ",id);
        return 1;
    }

    @Override
    public List<PostalNotification> findALL() {
        log.info("find all data in table messages ");
        return jdbcTemplate.query("SELECT * FROM messages", new PostalNotificationRowMapper());
    }

    public List<PostalNotification> findALLStatus() {
        log.info("find all data in table messages with status = new");
        return jdbcTemplate.query("select * from messages where status = 'new_message';",
                new PostalNotificationRowMapper());
    }

    public void changeStatus(List<PostalNotification> postalNotification){
        log.info("change status of message from new to delivered");
        for (int i = 0; i < postalNotification.size(); i++) {
            jdbcTemplate.update("update messages " +
                            "set (status, date_change_status) = (?, ?::timestamp)" +
                            "where id_notification = ?",
                    postalNotification.get(i).getStatus(),
                    postalNotification.get(i).getDateChangeStatus(),
                    postalNotification.get(i).getIdNotification());
        }
    }
}
