package com.icbt.restaurant.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;


    @GetMapping(path = "/{page}/{page_size}/{order}")
    ResponseEntity<?>Get(@PathVariable int page ,@PathVariable int page_size,@PathVariable int order){
        return reservationService.Get(page,page_size,order);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?>Get(@PathVariable int id){
        return reservationService.Get(id);
    }

    @PostMapping(path = "")
    ResponseEntity<?> Add(@RequestBody Reservation reservation) {
        return reservationService.Add(reservation);
    }

    @GetMapping(path = "/{page}/{page_size}/{order}/{status}")
    ResponseEntity<?> Get(@PathVariable int page, @PathVariable int page_size, @PathVariable int order, @PathVariable int status) {
        return reservationService.Get(page, page_size, order,status);
    }

}
