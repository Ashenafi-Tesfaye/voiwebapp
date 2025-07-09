package com.voi.voiwebapp.dto;

public class VehicleStatsDTO {
    private long total;
    private long silverAlerts;
    private long amberAlerts;
    private long stolen;
    private long warrants;
    
    public VehicleStatsDTO() {}
    
    public VehicleStatsDTO(long total, long silverAlerts, long amberAlerts, long stolen, long warrants) {
        this.total = total;
        this.silverAlerts = silverAlerts;
        this.amberAlerts = amberAlerts;
        this.stolen = stolen;
        this.warrants = warrants;
    }
    
    public long getTotal() {
        return total;
    }
    
    public void setTotal(long total) {
        this.total = total;
    }
    
    public long getSilverAlerts() {
        return silverAlerts;
    }
    
    public void setSilverAlerts(long silverAlerts) {
        this.silverAlerts = silverAlerts;
    }
    
    public long getAmberAlerts() {
        return amberAlerts;
    }
    
    public void setAmberAlerts(long amberAlerts) {
        this.amberAlerts = amberAlerts;
    }
    
    public long getStolen() {
        return stolen;
    }
    
    public void setStolen(long stolen) {
        this.stolen = stolen;
    }
    
    public long getWarrants() {
        return warrants;
    }
    
    public void setWarrants(long warrants) {
        this.warrants = warrants;
    }
}
