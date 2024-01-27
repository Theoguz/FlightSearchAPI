package com.example.flightsearchapi.mapper;

import com.example.flightsearchapi.dto.AirportDto;
import com.example.flightsearchapi.entity.Airport;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class AirportMapper {

    public AirportDto maptoAirportDto(Airport source) {
        AirportDto target = new AirportDto();
        target.setCity(source.getCity());
        return target;
    }
}
