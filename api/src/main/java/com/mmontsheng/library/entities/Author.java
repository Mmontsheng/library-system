package com.mmontsheng.library.entities;

import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Author extends Base {

    @Column(length = 20, nullable = false)
    private String name;
    
    @Column(length = 20, nullable = false)
    private String surname;
    
    private Boolean enabled;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Book> books;
    
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
    
    public String getNames() {
        return name + " " + surname;
    }
}
