package com.newTask.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="records")
public class MyRecord {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="firstName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    @Id
    @Column(name="emailAddress")
    private String emailAddress;
    
    public MyRecord() {
        super();
    }

    public MyRecord(String firstName, String lastName, String emailAddress) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "MyRecord [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
                + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmailAddress()="
                + getEmailAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
}
