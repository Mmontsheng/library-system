package com.mmontsheng.library.entities;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Base {

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "text", unique = true)
    private String summary;

    @Column(nullable = false, columnDefinition = "text")
    private String image;

    private Integer year;

    @JsonProperty("ISBN")
    @Column(nullable = false, unique = true)
    private Integer isbn;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn(nullable = false, name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(nullable = false, name = "category_id")
    private Category category;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.setEnabled(true);
        this.created = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModified = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    } 
}
