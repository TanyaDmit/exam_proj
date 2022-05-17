package com.fintech.examproj.repository.postalpackage;

import com.fintech.examproj.entity.PostalPackage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalPackageRowMapper implements RowMapper<PostalPackage> {
    @Override
    public PostalPackage mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostalPackage postalPackage = new PostalPackage();
        postalPackage.setIdPackage(rs.getLong("id_package"));
        postalPackage.setTelephoneSender(rs.getString("telephone_sender"));
        postalPackage.setNumOfficeRecipient(rs.getLong("num_office_recipient"));
        postalPackage.setTelephone(rs.getString("telephone"));
        postalPackage.setFirstNamePackage(rs.getString("first_name"));
        postalPackage.setLastNamePackage(rs.getString("last_name"));
        postalPackage.setPatronymic(rs.getString("patronymic"));
        postalPackage.setStatus(rs.getString("status"));
        postalPackage.setDateOfCreate(rs.getString("date_of_create"));//?
        postalPackage.setDateChangeStatus(rs.getString("date_change_status"));//?
        return postalPackage;
    }
}
