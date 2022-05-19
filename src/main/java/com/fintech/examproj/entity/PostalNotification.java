package com.fintech.examproj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("messages")
public class PostalNotification {
    @Id
    @Column(name = "id_message")
    private Long idNotification;
    @Column(name = "num_package")
    private Long numberPackage;
    @Column(name = "text_message")
    private String textMessage;
    @Column(name = "status")
    private String status;

    public PostalNotification(Long numberPackage, String textMessage){
        this.numberPackage = numberPackage;
        this.textMessage= textMessage;
    }

}
