package com.randstad.employee_management.model;
import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     *  employee id
     */
    private Long id;

    @Column(name = "first_name")
    /**
     * employee first name
     */
    private String firstName;

    @Column(name = "last_name")
    /**
     * employee last name
     */
    private String lastName;

    @Column(name = "email")
    /**
     * employee email
     */
    private String email;

    @Column(name="password")
    /**
     * employee password
     */
    private String password;

    @Column(name = "address")
    /**
     * employee address
     */
    private String address;

    @Column(name="city")
    /**
     * employee city
     */
    private String city;

    @Column(name ="state")
    /**
     * employee state
     */
    private String state;

    @OneToOne
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    /**
     * employee country
     */
    private Country country;

    /**
     *  gets the id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * sets the id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *  gets the first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the address
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets the city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * sets the city
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * gets the state
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * sets the state
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * gets the email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
