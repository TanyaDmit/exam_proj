package com.fintech.examproj.repository.postaloffice;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.repository.postalclient.PostalClientRepositoryImpl;
import com.fintech.examproj.repository.postalclient.PostalClientRowMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostalOfficeRepositoryImpl implements PostalOfficeRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger log = Logger.getLogger(PostalOfficeRepositoryImpl.class);

    @Override
    public int save(PostalOffice postalOffice) {
        log.info("insert into table offices: " + postalOffice);
        return jdbcTemplate.update("INSERT INTO offices(office_number, description) " +
                        "values(?::int, ?)",
                postalOffice.getOfficeNumber(),
                postalOffice.getDescription());
    }

    @Override
    public int delete(long id) {
        log.info("delete office from table offices");
        return jdbcTemplate.update("DELETE FROM offices where id_office = ? ",id);
    }

    @Override
    public List<PostalOffice> findALL() {
        log.info("find all data in table offices ");
        return jdbcTemplate.query("SELECT * FROM offices", new PostalOfficeRowMapper());
    }
}
