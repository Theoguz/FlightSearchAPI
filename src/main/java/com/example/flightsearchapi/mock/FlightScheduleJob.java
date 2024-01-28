package com.example.flightsearchapi.mock;

import com.example.flightsearchapi.entity.Airport;
import com.example.flightsearchapi.entity.Flight;
import com.example.flightsearchapi.repository.FlightRepository;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightScheduleJob {

    private final FlightRepository flightRepository;

    public FlightScheduleJob(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleFlight() {

        flightRepository.deleteAll();
        flightRepository.saveAll(createFlight());

    }


    private List<Flight> createFlight() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport(1L, "Istanbul"));
        airports.add(new Airport(2L, "Ankara"));
        airports.add(new Airport(3L, "Izmir"));
        airports.add(new Airport(4L, "Antalya"));
        airports.add(new Airport(5L, "Adana"));
        airports.add(new Airport(6L, "Trabzon"));
        airports.add(new Airport(7L, "Bursa"));
        airports.add(new Airport(8L, "Konya"));
        airports.add(new Airport(9L, "Gaziantep"));
        airports.add(new Airport(10L, "Diyarbakir"));
        for (int i = 0; i < 100; i++) {
            Flight flight = new Flight();
            flight.setDeparture_airport(airports.get(random.nextInt(10)));
            flight.setArrival_airport(airports.get(random.nextInt(10)));
            flight.setDeparture_time(LocalDate.now().plusDays(random.nextInt(1)));
            flight.setReturn_time(LocalDate.now().plusDays(random.nextInt(10)));
            flight.setPrice((double) random.nextInt(1000));
            flights.add(flight);
        }
        return flightRepository.saveAll(flights);
    }

}
