package com.icbt.restaurant.Reservation;

import com.icbt.restaurant.Branch.Branch;
import com.icbt.restaurant.JWT.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    LocalDateTime create_at;

    @Column
    Integer branch;

    @Column
    LocalDate reservationDate;

    @Column
    Integer menuId;

    @Column
    Integer restaurantMenuItem;

    @Column
    Integer userId;

    @Column
    Integer rate;

    @Column
    Integer complete_status; // 1 - pending // 2 - complete //3 - rated

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "branch", insertable = false, updatable = false)
    Branch branchDetails;

}