package com.eclipseeio.emi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Additional_Requirements")

public class AdditionalRequirements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = " AdditionalRequirements_name", unique = true)
    @NotNull
    private String additionalRequirementsName;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @OneToOne(cascade=CascadeType.ALL)
    private Company company;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdditionalRequirementsName() {
        return additionalRequirementsName;
    }

    public void setAdditionalRequirementsName(String additionalRequirementsName) {
        this.additionalRequirementsName = additionalRequirementsName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
