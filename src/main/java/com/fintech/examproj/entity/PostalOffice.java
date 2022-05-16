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
@Table("offices")
public class PostalOffice {
    @Id
    private Long idOffice;
    @Column(name = "office_number")
    private String officeNumber;
    @Column(name = "description")
    private String description;

}
