package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.dto.FlightDto;
import com.example.flightsearchapi.entity.Flight;
import com.example.flightsearchapi.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public List<FlightDto> GetAllFlights() {
        return flightService.getAll();
    }

    @PostMapping("/add")
    public FlightDto addFlight(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @GetMapping("/{id}")
    public FlightDto findById(@PathVariable Long id) {
        return flightService.findById(id);
    }

    @DeleteMapping("/{id}")
    public FlightDto deleteById(@PathVariable Long id) throws Exception {
        return flightService.deleteById(id);

    }

    @PutMapping("/{id}")
    public FlightDto changeFlight(@PathVariable Long id, @RequestBody Flight flight) {
        flightService.changeFlight(id, flight);
        return flightService.findById(id);
    }


}
