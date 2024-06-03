package com.hoaxvo.hrs.service;

import com.hoaxvo.hrs.dto.ReservationDTO;
import com.hoaxvo.hrs.dto.request.CreateReservationRequestDTO;
import com.hoaxvo.hrs.dto.request.EditReservationRequestDTO;

public interface ReservationService {
    void createReservation(CreateReservationRequestDTO requestDTO);

    void editReservation(Long id, EditReservationRequestDTO requestDTO);

    ReservationDTO getDetail(Long id);
}
