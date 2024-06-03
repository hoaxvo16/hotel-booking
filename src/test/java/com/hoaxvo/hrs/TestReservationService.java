package com.hoaxvo.hrs;

import com.hoaxvo.hrs.dto.ReservationDTO;
import com.hoaxvo.hrs.dto.request.CreateReservationRequestDTO;
import com.hoaxvo.hrs.dto.request.EditReservationRequestDTO;
import com.hoaxvo.hrs.entity.Reservation;
import com.hoaxvo.hrs.repositoriy.ReservationRepository;
import com.hoaxvo.hrs.service.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.Optional;

@SpringBootTest
public class TestReservationService {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testCreateReservation() {
        CreateReservationRequestDTO createReservationRequestDTO = new CreateReservationRequestDTO();
        createReservationRequestDTO.setCheckInDate(ZonedDateTime.now());
        createReservationRequestDTO.setCheckOutDate(ZonedDateTime.now().plusDays(5));
        createReservationRequestDTO.setRoomId(3L);
        Assertions.assertDoesNotThrow(() -> reservationService.createReservation(createReservationRequestDTO),
                "Exception occurs when create reservation");
        Optional<Reservation> reservation = reservationRepository.findByRoom_Id(createReservationRequestDTO.getRoomId());
        Assertions.assertTrue(reservation.isPresent(), "Reservation was not created");
    }

    @Test
    public void testEditReservation() {
        EditReservationRequestDTO editReservationRequestDTO = new EditReservationRequestDTO();
        editReservationRequestDTO.setCheckInDate(ZonedDateTime.now());
        ZonedDateTime checkOutDate = ZonedDateTime.now().plusDays(2);
        editReservationRequestDTO.setCheckOutDate(checkOutDate);
        editReservationRequestDTO.setRoomId(3L);
        Assertions.assertDoesNotThrow(() -> reservationService.editReservation(1L, editReservationRequestDTO),
                "Exception occurs when edit reservation");
        Optional<Reservation> reservation = reservationRepository.findByRoom_Id(editReservationRequestDTO.getRoomId());
        Assertions.assertTrue(reservation.isPresent(), "Reservation was deleted");
        Assertions.assertTrue(reservation.get().getCheckOutDate().isEqual(checkOutDate), "Check out date was not updated");
    }

    @Test
    public void testGetReservation() {
        Assertions.assertDoesNotThrow(()-> reservationService.getDetail(1L),"Exception occurs when get reservation");
    }

}
