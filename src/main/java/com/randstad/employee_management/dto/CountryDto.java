package com.randstad.employee_management.dto;

public class CountryDto {
    private int id;
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
     * sets the country name
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
