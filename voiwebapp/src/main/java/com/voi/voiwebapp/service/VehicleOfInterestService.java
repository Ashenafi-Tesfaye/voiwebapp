package com.voi.voiwebapp.service;

import com.voi.voiwebapp.dto.VehicleDTO;
import com.voi.voiwebapp.dto.VehicleStatsDTO;
import com.voi.voiwebapp.entity.VehicleOfInterest;
import com.voi.voiwebapp.repository.VehicleOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleOfInterestService {
    
    @Autowired
    private VehicleOfInterestRepository vehicleRepository;
    
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public Optional<VehicleDTO> getVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findById(licensePlate)
                .map(this::convertToDTO);
    }
    
    public List<VehicleDTO> searchVehicles(String licensePlate, String reason, String make, String color, String year) {
        return vehicleRepository.findBySearchCriteria(licensePlate, reason, make, color, year)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<VehicleDTO> getVehiclesByReason(String reason) {
        return vehicleRepository.findByReason(reason)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<VehicleDTO> getRecentVehicles() {
        return vehicleRepository.findTop10ByOrderByUpdatedDateDesc()
                .stream()
                .limit(10)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public VehicleStatsDTO getVehicleStats() {
        long total = vehicleRepository.count();
        long silverAlerts = vehicleRepository.countByReason("Silver Alert");
        long amberAlerts = vehicleRepository.countByReason("Amber Alert");
        long stolen = vehicleRepository.countByReason("Stolen");
        long warrants = vehicleRepository.countByReason("Arrest Warrant");
        
        return new VehicleStatsDTO(total, silverAlerts, amberAlerts, stolen, warrants);
    }
    
    public List<String> getDistinctReasons() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleOfInterest::getReason)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public List<String> getDistinctMakes() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleOfInterest::getMake)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public List<String> getDistinctColors() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleOfInterest::getColor)
                .filter(color -> color != null && !color.trim().isEmpty())
                .map(String::trim)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public List<String> getDistinctYears() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleOfInterest::getVehicleYear)
                .filter(year -> year != null && !year.trim().isEmpty())
                .map(String::trim)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    
    private VehicleDTO convertToDTO(VehicleOfInterest vehicle) {
        return new VehicleDTO(
                vehicle.getLicensePlate(),
                vehicle.getReason(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getVehicleYear() != null ? vehicle.getVehicleYear().trim() : null,
                vehicle.getColor() != null ? vehicle.getColor().trim() : null,
                vehicle.getOwnersName() != null ? vehicle.getOwnersName().trim() : null,
                vehicle.getOwnersPhone(),
                vehicle.getUpdatedDate()
        );
    }
}
