package com.mmontsheng.library.entities;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Inventory extends Base {

    @Column(length = 38, nullable = false)
    private String bookId;

    private Integer count;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.created = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModified = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    }
}
