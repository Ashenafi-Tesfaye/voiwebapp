package com.voi.voiwebapp.controller;

import com.voi.voiwebapp.dto.VehicleDTO;
import com.voi.voiwebapp.dto.VehicleStatsDTO;
import com.voi.voiwebapp.service.VehicleOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleOfInterestController {
    
    @Autowired
    private VehicleOfInterestService vehicleService;
    
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/{licensePlate}")
    public ResponseEntity<VehicleDTO> getVehicleByLicensePlate(@PathVariable String licensePlate) {
        Optional<VehicleDTO> vehicle = vehicleService.getVehicleByLicensePlate(licensePlate);
        return vehicle.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<VehicleDTO>> searchVehicles(
            @RequestParam(required = false) String licensePlate,
            @RequestParam(required = false) String reason,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String year) {
        
        List<VehicleDTO> vehicles = vehicleService.searchVehicles(licensePlate, reason, make, color, year);
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/reason/{reason}")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByReason(@PathVariable String reason) {
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByReason(reason);
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/stats")
    public ResponseEntity<VehicleStatsDTO> getVehicleStats() {
        VehicleStatsDTO stats = vehicleService.getVehicleStats();
        return ResponseEntity.ok(stats);
    }
    
    @GetMapping("/recent")
    public ResponseEntity<List<VehicleDTO>> getRecentVehicles() {
        List<VehicleDTO> recent = vehicleService.getRecentVehicles();
        return ResponseEntity.ok(recent);
    }
    
    @GetMapping("/reasons")
    public ResponseEntity<List<String>> getDistinctReasons() {
        List<String> reasons = vehicleService.getDistinctReasons();
        return ResponseEntity.ok(reasons);
    }
    
    @GetMapping("/makes")
    public ResponseEntity<List<String>> getDistinctMakes() {
        List<String> makes = vehicleService.getDistinctMakes();
        return ResponseEntity.ok(makes);
    }
    
    @GetMapping("/colors")
    public ResponseEntity<List<String>> getDistinctColors() {
        List<String> colors = vehicleService.getDistinctColors();
        return ResponseEntity.ok(colors);
    }
    
    @GetMapping("/years")
    public ResponseEntity<List<String>> getDistinctYears() {
        List<String> years = vehicleService.getDistinctYears();
        return ResponseEntity.ok(years);
    }
}
