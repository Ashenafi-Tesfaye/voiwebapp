-- Schema creation for Vehicle of Interest application
-- This file creates the table structure for the VOI database

CREATE TABLE IF NOT EXISTS vehicle_of_interest (
    license_plate VARCHAR(10) PRIMARY KEY,
    reason VARCHAR(50) NOT NULL,
    make VARCHAR(30),
    model VARCHAR(30),
    veh_year VARCHAR(10),
    color VARCHAR(20),
    owners_name VARCHAR(100),
    owners_phone VARCHAR(15),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for better query performance
CREATE INDEX IF NOT EXISTS idx_voi_reason ON vehicle_of_interest(reason);
CREATE INDEX IF NOT EXISTS idx_voi_make ON vehicle_of_interest(make);
CREATE INDEX IF NOT EXISTS idx_voi_color ON vehicle_of_interest(color);
CREATE INDEX IF NOT EXISTS idx_voi_year ON vehicle_of_interest(veh_year);
CREATE INDEX IF NOT EXISTS idx_voi_updated ON vehicle_of_interest(updated_date);
