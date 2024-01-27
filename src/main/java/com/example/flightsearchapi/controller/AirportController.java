package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.dto.AirportDto;
import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/airport")
public class AirportController {

    private final AirportService airportService;  //@Autowired

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/add")
    public AirportDto addAirport(@RequestBody Airport airport) {
        return airportService.save(airport);
    }

    @GetMapping("/all")
    public List<AirportDto> GetAllAirports() {
        return airportService.findAll();
    }

    @DeleteMapping("/{id}")
    public AirportDto deleteById(@PathVariable Long id) throws Exception {
        return airportService.deleteById(id);
    }

    @GetMapping("/{id}")
    public AirportDto findById(@PathVariable Long id) {
        return airportService.findById(id);
    }

}
