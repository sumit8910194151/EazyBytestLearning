package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter@MappedSuperclass
@Setter@ToString
@EntityListeners(AuditingEntityListener.class)// used to get the audit information from auditawareimpl class
public class BaseEntity {

    //@MappedSuperClass anotation creates this class a super class where I am extending this class

    @Column(updatable = false) //Indicates that this field should not be updated when update operation is performed
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(updatable = false)
    @CreatedBy
    private String createdBy;
    @Column(insertable = false) //Indicates that this field should not be inserted when it is creating new Record

    @LastModifiedDate private LocalDateTime updatedAt;
    @Column(insertable = false)
    @LastModifiedBy
    private String updatedBy;
}
