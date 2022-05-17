package com.fintech.examproj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("packages")
public class PostalPackage {
    @Id
    private Long idPackage;
    @Column(name = "telephone_sender")
    private String telephoneSender;
    @Column(name = "num_office_recipient")
    private Long numOfficeRecipient;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "first_name")
    private String firstNamePackage;
    @Column(name="last_name")
    private String lastNamePackage;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "status")
    private String status;
    @Column(name = "date_of_create")
    private String dateOfCreate;
    @Column(name = "date_change_status")
    private String dateChangeStatus;
}
