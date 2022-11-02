package org.ncu.hirewheels.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehicle_subcategory")
public class VehicleSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_subcategory_id", columnDefinition = "numeric(10)")
    private Integer vehicle_subcategory_id;

    @Column(name = "vehicle_subcategory_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String vehicle_subcategory_name;

    @Column(name = "price_per_day", columnDefinition = "numeric(10,2)", nullable = false)
    private Integer price_per_day;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_category_id", columnDefinition = "numeric(10)", nullable = false)
    private VehicleCategory vehicleCategory;

    @OneToMany(mappedBy = "vehicleSubcategory",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
