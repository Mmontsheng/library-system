package com.mmontsheng.library.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
public class Base {

    @Id
    @Column(nullable = false, length = 38)
    protected String id;
        
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    protected Calendar created;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    protected Calendar lastModified;

    @JsonIgnore
    public String getCreated() {
        if (created == null) {
            return null;
        }

        Date dt = created.getTime();
        DateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        return f.format(dt);
    }

    @JsonIgnore
    public Calendar getCreatedCal() {
        return created;
    }

    @JsonIgnore
    public String getLastModified() {
        if (lastModified == null) {
            return null;
        }

        Date dt = lastModified.getTime();
        DateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        return f.format(dt);
    }

    @JsonIgnore
    public Calendar getLastModifiedCal() {
        return lastModified;
    }
}
