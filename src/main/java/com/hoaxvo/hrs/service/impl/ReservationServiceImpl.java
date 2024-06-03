package com.hoaxvo.hrs.service.impl;

import com.hoaxvo.hrs.dto.ReservationDTO;
import com.hoaxvo.hrs.dto.common.Error;
import com.hoaxvo.hrs.dto.request.CreateReservationRequestDTO;
import com.hoaxvo.hrs.dto.request.EditReservationRequestDTO;
import com.hoaxvo.hrs.entity.User;
import com.hoaxvo.hrs.entity.Reservation;
import com.hoaxvo.hrs.entity.Room;
import com.hoaxvo.hrs.exception.DataNotFoundException;
import com.hoaxvo.hrs.exception.InvalidArgumentException;
import com.hoaxvo.hrs.exception.InvalidDataAccessException;
import com.hoaxvo.hrs.mapper.ReservationMapper;
import com.hoaxvo.hrs.repositoriy.UserRepository;
import com.hoaxvo.hrs.repositoriy.ReservationRepository;
import com.hoaxvo.hrs.repositoriy.RoomRepository;
import com.hoaxvo.hrs.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;

    @Override
    @Transactional
    public void createReservation(CreateReservationRequestDTO requestDTO) {
        long totalNight = validateCheckInCheckOutDate(requestDTO.getCheckInDate(), requestDTO.getCheckOutDate());
        long guestId = 1;
        Optional<Room> room = roomRepository.findById(requestDTO.getRoomId());
        if (room.isEmpty()) {
            throw new DataNotFoundException(Error.DE002);
        }
        checkRoomAvailable(requestDTO.getRoomId(), guestId);
        // Get this from token
        Optional<User> guest = userRepository.findById(guestId);
        if (guest.isEmpty()) {
            throw new DataNotFoundException(Error.DE001);
        }
        Reservation reservation = new Reservation();
        reservation.setUser(guest.get());
        reservation.setRoom(room.get());
        reservation.setCheckInDate(requestDTO.getCheckInDate());
        reservation.setCheckOutDate(requestDTO.getCheckOutDate());
        reservation.setPrice(room.get().getPricePerNight() * totalNight);
        reservationRepository.save(reservation);
    }

    @Override
    public void editReservation(Long id, EditReservationRequestDTO requestDTO) {
        long totalNight = validateCheckInCheckOutDate(requestDTO.getCheckInDate(), requestDTO.getCheckOutDate());
        long guestId = 1;
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new DataNotFoundException(Error.DE003);
        }
        Optional<Room> room = roomRepository.findById(requestDTO.getRoomId());
        if (room.isEmpty()) {
            throw new DataNotFoundException(Error.DE002);
        }
        checkRoomAvailable(requestDTO.getRoomId(), guestId);
        Reservation currentReservation = reservation.get();
        currentReservation.setRoom(room.get());
        currentReservation.setCheckInDate(requestDTO.getCheckInDate());
        currentReservation.setCheckOutDate(requestDTO.getCheckOutDate());
        currentReservation.setPrice(room.get().getPricePerNight() * totalNight);
        reservationRepository.save(currentReservation);
    }

    @Override
    public ReservationDTO getDetail(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new DataNotFoundException(Error.DE003);
        }
        return reservationMapper.toDTO(reservation.get());
    }

    private long validateCheckInCheckOutDate(ZonedDateTime checkInDate, ZonedDateTime checkOutDate) {
        long totalNight = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        if (checkInDate.isAfter(checkOutDate) || totalNight < 1) {
            throw new InvalidArgumentException(Error.IE001);
        }
        return totalNight;
    }

    private void checkRoomAvailable(Long roomId, Long guestId) {
        Optional<Reservation> reservation = reservationRepository.findByRoom_Id(roomId);
        if (reservation.isPresent() && !reservation.get().getUser().getId().equals(guestId)) {
            throw new InvalidDataAccessException(Error.DE004);
        }
    }
}
