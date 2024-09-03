package com.icbt.restaurant.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;


    @GetMapping(path = "/{page}/{page_size}/{order}")
    ResponseEntity<?>Get(@PathVariable int page ,@PathVariable int page_size,@PathVariable int order){
        return reservationService.Get(page,page_size,order);
    }

    @GetMapping(path = "/{page}/{page_size}/{order}/{status}")
    ResponseEntity<?> Get(@PathVariable int page, @PathVariable int page_size, @PathVariable int order, @PathVariable int status) {
        return reservationService.Get(page, page_size, order,status);
    }

}
