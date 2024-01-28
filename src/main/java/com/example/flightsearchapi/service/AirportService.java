package com.example.flightsearchapi.service;

import com.example.flightsearchapi.dto.AirportDto;
import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.mapper.AirportMapper;
import com.example.flightsearchapi.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public AirportService(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    public AirportDto save(Airport airport) {
        return airportMapper.maptoAirportDto(airportRepository.save(airport));
    }

    public List<AirportDto> findAll() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream().map(airportMapper::maptoAirportDto).toList();
    }

    public AirportDto findById(Long id) {
        return airportMapper.maptoAirportDto(airportRepository.findById(id).get());
    }

    public AirportDto deleteById(Long id) throws Exception {
        Optional<Airport> airport = airportRepository.findById(id);
        if (airport.isPresent()) {
            airportRepository.deleteById(id);
            return airportMapper.maptoAirportDto(airport.get());
        } else {
            throw new Exception("Airport not found");
        }
    }

    public void changeAirport(Long id, Airport airport) {
        Airport airport1 = airportRepository.findById(id).get();
        airport1.setCity(airport.getCity());
        airportRepository.save(airport1);
        airportMapper.maptoAirportDto(airport1);
    }





}
