package com.randstad.employee_management.model;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {

    @Id
    private int id;

    @Column(name = "country_name")
    private String countryName;

    /**
     * gets the country id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the country id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the country name
     * @return countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * sets the countryName
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}

