package com.icbt.restaurant.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepo reservationRepo;

    public ResponseEntity<?> Get(int page, int pageSize, int order) {
        return ResponseEntity.ok(reservationRepo.findAll(PageRequest.of(page, pageSize, Sort.by(order == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, "id"))));
    }

    public ResponseEntity<?> Get(int page, int pageSize, int order, int status) {
        return ResponseEntity.ok(reservationRepo.findByComplete_status(status, PageRequest.of(page, pageSize, Sort.by(order == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, "id"))));
    }
}
