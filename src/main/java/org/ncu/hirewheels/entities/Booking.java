package org.ncu.hirewheels.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", columnDefinition = "numeric(10)")
    private Integer booking_id;

    @Column(name = "pickup_date", columnDefinition = "date", nullable = false)
    private Date pickup_date;

    @Column(name = "dropoff_date", columnDefinition = "date", nullable = false)
    private Date dropoff_date;

    @Column(name = "booking_date", columnDefinition = "date", nullable = false)
    private Date booking_date;

    @Column(name = "amount", columnDefinition = "numeric(10,2)", nullable = false)
    private Integer amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", columnDefinition = "numeric(10)", nullable = false)
    private Location location;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", columnDefinition = "numeric(10)", nullable = false)
    private Vehicle vehicle;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "numeric(10)", nullable = false)
    private User user;


}
