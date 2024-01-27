package com.example.flightsearchapi.mapper;

import com.example.flightsearchapi.dto.FlightDto;
import com.example.flightsearchapi.entity.Flight;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class FlightMapper {

    public FlightDto maptoFlightDto(Flight source) {
        FlightDto target = new FlightDto();
        target.setDeparture_airport(source.getDeparture_airport());
        target.setArrival_airport(source.getArrival_airport());
        target.setDeparture_time(source.getDeparture_time());
        target.setReturn_time(source.getReturn_time());
        target.setPrice(source.getPrice());
        return target;
    }
}
