package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.dto.FlightDto;
import com.example.flightsearchapi.entity.Flight;
import com.example.flightsearchapi.service.FlightDirection;
import com.example.flightsearchapi.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> GetAllFlights() {
        try {
            List<FlightDto> flights = flightService.getAll();
            return ResponseEntity.ok(flights);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
        try {
            FlightDto flightDto = flightService.save(flight);
            return ResponseEntity.ok("Flight Created " + flightDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            FlightDto flightDto = flightService.findById(id);
            return ResponseEntity.ok(flightDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            FlightDto flightDto = flightService.deleteById(id);
            return ResponseEntity.ok("Flight Deleted" + flightDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> changeFlight(@PathVariable Long id, @RequestBody Flight flight) {
        try {
            flightService.changeFlight(id, flight);
            return ResponseEntity.ok("Flight Updated " + flightService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
