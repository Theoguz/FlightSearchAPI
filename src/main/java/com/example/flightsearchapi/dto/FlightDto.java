package com.example.flightsearchapi.dto;

import com.example.flightsearchapi.entity.Airport;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FlightDto {

    private Airport departure_airport;

    private Airport arrival_airport;

    private LocalDate departure_time;

    private LocalDate return_time;

    private Double price;


}
