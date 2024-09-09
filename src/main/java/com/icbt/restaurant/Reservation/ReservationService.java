package com.icbt.restaurant.Reservation;

import com.icbt.restaurant.Branch.Branch;
import com.icbt.restaurant.Branch.BranchRepo;
import com.icbt.restaurant.BranchTables.BranchTables;
import com.icbt.restaurant.BranchTables.BranchTablesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private BranchTablesRepo branchTablesRepo;

    public ResponseEntity<?> Get(int page, int pageSize, int order) {
        return ResponseEntity.ok(reservationRepo.findAll(PageRequest.of(page, pageSize, Sort.by(order == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, "id"))));
    }

    public ResponseEntity<?> Get(int page, int pageSize, int order, int status) {
        return ResponseEntity.ok(reservationRepo.findByComplete_status(status, PageRequest.of(page, pageSize, Sort.by(order == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, "id"))));
    }

    public ResponseEntity<?> Add(Reservation reservation) {
        long count =reservationRepo.countByReservationDate(LocalDate.now(),reservation.getBranch());
        Optional<BranchTables> branchOptional = branchTablesRepo.findByBranchId(reservation.getBranch());
        if(branchOptional.get().getTablesCount()>count){

        reservation.setReservationDate(LocalDate.now());
        reservation.setComplete_status(1); //1 pending ,2 complete
        reservation.setCreate_at(LocalDateTime.now());
        return ResponseEntity.ok(reservationRepo.save(reservation));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("fully booked !");
        }
    }

    public ResponseEntity<?> Get(int id) {
        Optional<Reservation> reservationOptional =reservationRepo.findById(id);
        if(reservationOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid reservation id");
        }else{
            reservationOptional.get().setComplete_status(2);
            return ResponseEntity.ok(reservationRepo.save(reservationOptional.get()));
        }
    }


}
