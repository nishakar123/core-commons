package com.nishakar.commons.enums;


public enum VehicleType {
    BUS,
    CAR,
    TRUCK,
    TEMPO,
    PICKUP,
    TOTO,
    MOTORCYCLE,
    CYCLE;

    public VehicleType getVehicleType(String vehicleType) {
        return VehicleType.valueOf(vehicleType.toUpperCase());
    }
}
