package com.arun.jobys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class baseEntity {
    //only use these fields while creation of data
    @CreatedDate
    @CreationTimestamp
    @Column(name = "Created_At", nullable = false, updatable = false)
    private Instant createdAt;

    @CreatedBy
    @Column(name = "Created_By", nullable = false, length = 20, updatable = false)
    private String createdBy;

    //only use these fields while updating data
    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "Updated_At", insertable = false)
    private Instant updatedAt;

    @LastModifiedBy
    @Column(name = "Updated_By", length = 20, insertable = false)
    private String updatedBy;
}
