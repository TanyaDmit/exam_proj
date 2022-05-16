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
@Table("clients")
public class PostalClient {

    @Id
    private Long idClient;
    @Column(name = "first_name")
    private String firstNameClient;
    @Column(name = "last_name")
    private String lastNameClient;
    @Column(name = "patronymic")
    private String patronymicClient;
    @Column(name = "email")
    private String emailClient;
    @Column(name = "telephone")
    private String loginClient;

}