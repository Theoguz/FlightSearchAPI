package com.example.flightsearchapi.service;

import com.example.flightsearchapi.dto.FlightDto;
import com.example.flightsearchapi.entity.Flight;
import com.example.flightsearchapi.mapper.FlightMapper;
import com.example.flightsearchapi.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    private final FlightMapper flightMapper;


    public FlightService(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    public FlightDto save(Flight flight) {
        return flightMapper.maptoFlightDto(flightRepository.save(flight));
    }

    public FlightDto findById(Long id) {
        return flightMapper.maptoFlightDto(flightRepository.findById(id).get());
    }

    public FlightDto deleteById(Long id) throws Exception {
        Flight flight = flightRepository.findById(id).get();
        if (flight != null) {
            flightRepository.deleteById(id);
            return flightMapper.maptoFlightDto(flight);
        } else {
            throw new Exception("Flight not found");
        }
    }

    public List<FlightDto> getAll() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(flightMapper::maptoFlightDto).toList();


    }

    public void changeFlight(Long id, Flight flight) {
        if (flightRepository.findById(id).isPresent()) {
            Flight flight1 = flightRepository.findById(id).get();
            flight1.setDeparture_airport(flight.getDeparture_airport());
            flight1.setArrival_airport(flight.getArrival_airport());
            flight1.setDeparture_time(flight.getDeparture_time());
            flight1.setReturn_time(flight.getReturn_time());
            flight1.setPrice(flight.getPrice());
            flightRepository.save(flight1);
            flightMapper.maptoFlightDto(flight1);
        } else {
            System.out.println("Flight not found");
        }
    }

//    Search API
//    Verilen kalkış yeri, varış yeri, kalkış tarihi ve dönüş tarihine uygun uçuşları listeleyen bir API endpoint yapılmalı.
//    Dönüş tarihi verilmediyse tek yönlü uçuş, verildiyse çift yönlü uçuştur.
//    Tek yönlü uçuş için tek uçuş bilgisi, çift yönlü uçuş için iki uçuş bilgisi verilmeli.

    public List<FlightDto> searchFlight(Map<String, String> allParams) {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture_airport().getCity().equals(allParams.get("departure_city")) &&
                    flight.getArrival_airport().getCity().equals(allParams.get("arrival_city")) &&
                    flight.getDeparture_time().equals(LocalDate.parse(allParams.get("departure_date")))) {
                flightDtos.add(flightMapper.maptoFlightDto(flight));
            }
            if (allParams.containsKey("return_date")) {
                if (flight.getDeparture_airport().getCity().equals(allParams.get("arrival_city")) &&
                        flight.getArrival_airport().getCity().equals(allParams.get("departure_city")) &&
                        flight.getDeparture_time().equals(LocalDate.parse(allParams.get("return_date")))) {
                    flightDtos.add(flightMapper.maptoFlightDto(flight));
                }
            }
        }
        return flightDtos;
    }


}
