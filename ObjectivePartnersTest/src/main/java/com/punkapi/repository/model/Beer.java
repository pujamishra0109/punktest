package com.punkapi.repository.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Puja on 10/04/20.
 */

@Data
@Entity
@Table(name="beer")
public class Beer {

    @Id
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "tagline")
    String tagline;

    @Column(name = "first_brewed")
    String first_brewed;

    @Column(name = "description",columnDefinition="TEXT")
    String description;

    @Column(name = "image_url")
    String image_url;

    public Beer() {
    }

    @Column(name = "abv")
    BigDecimal abv;

    public Beer(Long id, String name, String tagline, String first_brewed, String description, String image_url, BigDecimal abv) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.first_brewed = first_brewed;
        this.description = description;
        this.image_url = image_url;
        this.abv = abv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public BigDecimal getAbv() {
        return abv;
    }

    public void setAbv(BigDecimal abv) {
        this.abv = abv;
    }
}
