package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter@MappedSuperclass
@Setter@ToString
public class BaseEntity {

    //@MappedSuperClass anotation creates this class a super class where I am extending this class

    @Column(updatable = false) //Indicates that this field should not be updated when update operation is performed
    private LocalDateTime createdAt;
    @Column(updatable = false)
    private String createdBy;
    @Column(insertable = false) //Indicates that this field should not be inserted when it is creating new Record
    private LocalDateTime updatedAt;
    @Column(insertable = false)
    private String updatedBy;
}
