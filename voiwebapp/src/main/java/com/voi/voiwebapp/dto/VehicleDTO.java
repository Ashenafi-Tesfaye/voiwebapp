package com.voi.voiwebapp.dto;

import java.time.LocalDateTime;

public class VehicleDTO {
    private String licensePlate;
    private String reason;
    private String make;
    private String model;
    private String vehicleYear;
    private String color;
    private String ownersName;
    private String ownersPhone;
    private LocalDateTime updatedDate;
    
    public VehicleDTO() {}
    
    public VehicleDTO(String licensePlate, String reason, String make, String model, 
                     String vehicleYear, String color, String ownersName, String ownersPhone, 
                     LocalDateTime updatedDate) {
        this.licensePlate = licensePlate;
        this.reason = reason;
        this.make = make;
        this.model = model;
        this.vehicleYear = vehicleYear;
        this.color = color;
        this.ownersName = ownersName;
        this.ownersPhone = ownersPhone;
        this.updatedDate = updatedDate;
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
    
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
    
    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
