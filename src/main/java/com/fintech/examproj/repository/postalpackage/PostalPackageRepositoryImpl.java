package com.fintech.examproj.repository.postalpackage;

import com.fintech.examproj.entity.PostalPackage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PostalPackageRepositoryImpl implements PostalPackageRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger log = Logger.getLogger(PostalPackageRepositoryImpl.class);
    @Override
    public int save(PostalPackage postalPackage) {
        log.info("insert into table packages: " + postalPackage);
        return jdbcTemplate.update("INSERT INTO packages" +
                "(telephone_sender, num_office_recipient, telephone, first_name," +
                "last_name, patronymic, status) values (?, ?::int, ?, ?, ?, ?, 'new_package')",
            postalPackage.getTelephoneSender(),
            postalPackage.getNumOfficeRecipient(),
            postalPackage.getTelephone(),
            postalPackage.getFirstNamePackage(),
            postalPackage.getLastNamePackage(),
            postalPackage.getPatronymic());
    }

    @Override
    public int delete(long id) {
        log.info("delete package from table packages");
        return jdbcTemplate.update("DELETE FROM packages where id_package = ? ",id);
    }

    @Override
    public List<PostalPackage> findALL() {
        log.info("find all data in table packages ");
        return jdbcTemplate.query("SELECT * FROM packages", new PostalPackageRowMapper());
    }

    public List<PostalPackage> findALLStatus(){
        log.info("find status and date_change_status from packages ");
        return jdbcTemplate.query("SELECT to_char(date_change_status, 'YYYY-MM-DD HH24:MI:SS') as d1, " +
                    "status," +
                    "id_package FROM packages where status = 'new_package'",
                    new PostalPackageRowMapper());
    }

    public void updateStatus(List<PostalPackage> postalPackage) {
        log.info("update status package ");
        for (int i = 0; i < postalPackage.size(); i++) {
            jdbcTemplate.update("update packages " +
                            "set (status, date_change_status) = (?, ?::timestamp)" +
                            "where id_package = ?",
                    postalPackage.get(i).getStatus(),
                    postalPackage.get(i).getDateChangeStatus(),
                    postalPackage.get(i).getIdPackage());
        }
    }
}
