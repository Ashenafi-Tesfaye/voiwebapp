package com.voi.voiwebapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_of_interest")
public class VehicleOfInterest {
    
    @Id
    @Column(name = "license_plate", length = 10)
    private String licensePlate;
    
    @Column(name = "reason", length = 50, nullable = false)
    private String reason;
    
    @Column(name = "make", length = 30)
    private String make;
    
    @Column(name = "model", length = 30)
    private String model;
    
    @Column(name = "veh_year", length = 10)
    private String vehicleYear;
    
    @Column(name = "color", length = 20)
    private String color;
    
    @Column(name = "owners_name", length = 100)
    private String ownersName;
    
    @Column(name = "owners_phone", length = 15)
    private String ownersPhone;
    
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    
    // Constructors
    public VehicleOfInterest() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }
    
    public VehicleOfInterest(String licensePlate, String reason, String make, String model, 
                           String vehicleYear, String color, String ownersName, String ownersPhone) {
        this();
        this.licensePlate = licensePlate;
        this.reason = reason;
        this.make = make;
        this.model = model;
        this.vehicleYear = vehicleYear;
        this.color = color;
        this.ownersName = ownersName;
        this.ownersPhone = ownersPhone;
    }
    
    // Getters and Setters
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getVehicleYear() {
        return vehicleYear;
    }
    
    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getOwnersName() {
        return ownersName;
    }
    
    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }
    
    public String getOwnersPhone() {
        return ownersPhone;
    }
    
    public void setOwnersPhone(String ownersPhone) {
        this.ownersPhone = ownersPhone;
    }
    
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
    
    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
