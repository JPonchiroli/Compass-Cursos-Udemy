package com.pbcompass.park_api.web.dto.mapper;

import com.pbcompass.park_api.entities.ParkingSpot;
import com.pbcompass.park_api.web.dto.ParkingSpotCreateDto;
import com.pbcompass.park_api.web.dto.ParkingSpotResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingSpotMapper {

    public static ParkingSpot toParkingSpot(ParkingSpotCreateDto dto){
        return new ModelMapper().map(dto, ParkingSpot.class);
    }

    public static ParkingSpotResponseDto toDto(ParkingSpot parkingSpot){
        return new ModelMapper().map(parkingSpot, ParkingSpotResponseDto.class);
    }
}
