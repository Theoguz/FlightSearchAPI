package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.dto.AirportDto;
import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/airport")
public class AirportController {

    private final AirportService airportService;  //@Autowired

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addAirport(@RequestBody Airport airport) {
        try {
            AirportDto airportDto = airportService.save(airport);
            return ResponseEntity.ok(" Airport Created " + airportDto.getCity());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> GetAllAirports() {
        try {
            List<AirportDto> airports = airportService.findAll();
            return ResponseEntity.ok(airports);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            AirportDto airportDto = airportService.findById(id);
            return ResponseEntity.ok(airportDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception {
        try {
            AirportDto airportDto = airportService.deleteById(id);
            return ResponseEntity.ok("Airport Deleted" + airportDto.getCity());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> changeById(@PathVariable Long id, @RequestBody Airport airport) {
        try {
            airportService.changeAirport(id, airport);
            return ResponseEntity.ok("Airport updated" + airportService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
