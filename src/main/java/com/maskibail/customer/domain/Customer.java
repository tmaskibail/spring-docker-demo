package com.maskibail.customer.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "customer_id_generator")
    private Integer id;

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private  String phone;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
