package com.arun.jobys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class baseEntity {
    @Column(name = "Created_At", nullable = false)
    private Instant createdAt;

    @Column(name = "Created_By", nullable = false, length = 20)
    private String createdBy;

    @Column(name = "Updated_At")
    private Instant updatedAt;

    @Column(name = "Updated_By", length = 20)
    private String updatedBy;
}
