package com.runverve.runvervedemoproject.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class UserMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private double distance;         // in kilometers
    private String time;             // e.g., "00:45:00"
    private double pace;            // in min/km
    private int steps;
    private int caloriesBurned;

    private int heartRate;          // average bpm
    private String sleepData;       // e.g., "7h 30m"
    private String recoveryMetrics;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date localDate;

//    private String userName;
//    private String userMail;
//    private int userAge;
//    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
