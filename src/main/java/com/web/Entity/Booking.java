package com.web.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date scheduleDate;
    private String slot;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String typeOfCancer;
    private String remarks;
}
