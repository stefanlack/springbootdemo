package com.opitzconsulting.springbootdemo.aufgaben.db;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

/**
 * Basisklasse für alle Entitäten.
 * <p>
 * Zum Zeitpunkt der Erstellung ist die Anlage der Klasse vielleicht vom "speculative generality code smell" betroffen....
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class AbstractBaseEntity {

    @Column(name = "CREATED_AT")
    @CreatedDate
    @EqualsAndHashCode.Include
    protected OffsetDateTime createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    @EqualsAndHashCode.Include
    protected OffsetDateTime updatedAt;
}
