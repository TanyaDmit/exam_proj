package com.fintech.examproj.repository.postaloffice;

import com.fintech.examproj.entity.PostalOffice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalOfficeRowMapper implements RowMapper<PostalOffice> {
    @Override
    public PostalOffice mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostalOffice postalOffice = new PostalOffice();
        postalOffice.setIdOffice(rs.getLong("id_office"));
        postalOffice.setOfficeNumber(rs.getString("office_number"));
        postalOffice.setDescription(rs.getString("description"));
        return postalOffice;
    }
}
