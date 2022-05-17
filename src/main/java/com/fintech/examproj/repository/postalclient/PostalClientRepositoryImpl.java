package com.fintech.examproj.repository.postalclient;

import com.fintech.examproj.entity.PostalClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostalClientRepositoryImpl implements PostalClientRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger log = Logger.getLogger(PostalClientRepositoryImpl.class);
    @Override
    public int save(PostalClient postalClient) {
        log.info("insert into table clients: " + postalClient);
        return jdbcTemplate.update("INSERT INTO clients(first_name, last_name, patronymic, email, telephone) " +
                        "values(?, ?, ?, ?, ?)",
                postalClient.getFirstNameClient(),
                postalClient.getLastNameClient(),
                postalClient.getPatronymicClient(),
                postalClient.getEmailClient(),
                postalClient.getLoginClient());
    }

    @Override
    public int delete(long id) {
        log.info("delete client from table clients");
        return jdbcTemplate.update("DELETE FROM clients where id_client = ? ",id);
    }

    @Override
    public List<PostalClient> findALL() {
        log.info("find all data in table clients: ");
        return jdbcTemplate.query("SELECT * FROM clients", new PostalClientRowMapper());
    }
}
