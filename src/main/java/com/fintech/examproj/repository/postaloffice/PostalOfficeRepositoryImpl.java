package com.fintech.examproj.repository.postaloffice;

import com.fintech.examproj.entity.PostalClient;
import com.fintech.examproj.entity.PostalOffice;
import com.fintech.examproj.repository.postalclient.PostalClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostalOfficeRepositoryImpl implements PostalOfficeRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(PostalOffice postalOffice) {
        return jdbcTemplate.update("INSERT INTO offices(office_number, description) " +
                        "values(?, ?)",
                postalOffice.getOfficeNumber(),
                postalOffice.getDescription());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM offices where id_office = ? ",id);
    }

    @Override
    public List<PostalOffice> findALL() {
        return jdbcTemplate.query("SELECT * FROM offices", new PostalOfficeRowMapper());
    }
}
