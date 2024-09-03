package com.icbt.restaurant.Reservation;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

    @Query("select r from Reservation r where r.complete_status = ?1")
    List<Reservation> findByComplete_status(Integer complete_status, PageRequest pageRequest);
}