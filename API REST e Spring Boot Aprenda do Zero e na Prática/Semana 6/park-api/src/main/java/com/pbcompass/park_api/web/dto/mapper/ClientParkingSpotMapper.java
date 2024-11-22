package com.pbcompass.park_api.web.dto.mapper;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.web.dto.ParkingLotCreateDto;
import com.pbcompass.park_api.web.dto.ParkingLotResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientParkingSpotMapper {

    public static ClientParkingSpot toClientParkingSpot(ParkingLotCreateDto dto) {
        return new ModelMapper().map(dto, ClientParkingSpot.class);
    }

    public static ParkingLotResponseDto toClientParkingSpot(ClientParkingSpot clientParkingSpot) {
        return new ModelMapper().map(clientParkingSpot, ParkingLotResponseDto.class);
    }
}
