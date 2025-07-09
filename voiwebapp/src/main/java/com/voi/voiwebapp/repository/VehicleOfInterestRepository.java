package com.voi.voiwebapp.repository;

import com.voi.voiwebapp.entity.VehicleOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleOfInterestRepository extends JpaRepository<VehicleOfInterest, String> {
    
    // Find by reason
    List<VehicleOfInterest> findByReason(String reason);
    
    // Find by make
    List<VehicleOfInterest> findByMake(String make);
    
    // Find by color
    List<VehicleOfInterest> findByColor(String color);
    
    // Find by year
    List<VehicleOfInterest> findByVehicleYear(String vehicleYear);
    
    // Find by license plate containing (partial search)
    List<VehicleOfInterest> findByLicensePlateContainingIgnoreCase(String licensePlate);
    
    // Find by owner name containing (partial search)
    List<VehicleOfInterest> findByOwnersNameContainingIgnoreCase(String ownersName);
    
    // Count by reason
    @Query("SELECT COUNT(v) FROM VehicleOfInterest v WHERE v.reason = :reason")
    long countByReason(@Param("reason") String reason);
    
    // Get recent entries (top 10)
    @Query("SELECT v FROM VehicleOfInterest v ORDER BY v.updatedDate DESC")
    List<VehicleOfInterest> findTop10ByOrderByUpdatedDateDesc();
    
    // Custom search query
    @Query("SELECT v FROM VehicleOfInterest v WHERE " +
           "(:licensePlate IS NULL OR UPPER(v.licensePlate) LIKE UPPER(CONCAT('%', :licensePlate, '%'))) AND " +
           "(:reason IS NULL OR v.reason = :reason) AND " +
           "(:make IS NULL OR v.make = :make) AND " +
           "(:color IS NULL OR v.color = :color) AND " +
           "(:year IS NULL OR v.vehicleYear = :year)")
    List<VehicleOfInterest> findBySearchCriteria(
            @Param("licensePlate") String licensePlate,
            @Param("reason") String reason,
            @Param("make") String make,
            @Param("color") String color,
            @Param("year") String year);
}
