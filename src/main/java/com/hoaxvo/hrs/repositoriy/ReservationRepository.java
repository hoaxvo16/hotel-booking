package com.hoaxvo.hrs.repositoriy;

import com.hoaxvo.hrs.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByRoom_Id(Long id);
}