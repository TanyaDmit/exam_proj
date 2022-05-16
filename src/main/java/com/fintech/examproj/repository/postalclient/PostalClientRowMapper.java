package com.fintech.examproj.repository.postalclient;

import com.fintech.examproj.entity.PostalClient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalClientRowMapper implements RowMapper<PostalClient> {
    @Override
    public PostalClient mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostalClient postalClient = new PostalClient();
        postalClient.setIdClient(rs.getLong("id_client"));
        postalClient.setFirstNameClient(rs.getString("first_name"));
        postalClient.setLastNameClient(rs.getString("last_name"));
        postalClient.setPatronymicClient(rs.getString("patronymic"));
        postalClient.setEmailClient(rs.getString("email"));
        postalClient.setLoginClient(rs.getString("telephone"));
        return postalClient;
    }
}