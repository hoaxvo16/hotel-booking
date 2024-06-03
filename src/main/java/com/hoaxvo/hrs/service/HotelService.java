package com.hoaxvo.hrs.service;

import com.hoaxvo.hrs.dto.HotelDTO;
import com.hoaxvo.hrs.dto.common.PaginationResponseDTO;
import com.hoaxvo.hrs.dto.request.CreateReservationRequestDTO;
import com.hoaxvo.hrs.dto.request.SearchHotelRequestDTO;

public interface HotelService {
    PaginationResponseDTO<HotelDTO> search(SearchHotelRequestDTO requestDTO);
}
