package com.hoaxvo.hrs;

import com.hoaxvo.hrs.dto.HotelDTO;
import com.hoaxvo.hrs.dto.common.PaginationResponseDTO;
import com.hoaxvo.hrs.dto.request.SearchHotelRequestDTO;
import com.hoaxvo.hrs.service.HotelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestHotelService {
    @Autowired
    private HotelService hotelService;

    @Test
    public void testSearchHotel() {
        SearchHotelRequestDTO requestDTO = new SearchHotelRequestDTO();
        requestDTO.setCity("Angeles");
        requestDTO.setState("CA");
        requestDTO.setPage(0);
        requestDTO.setLimit(10);
        PaginationResponseDTO<HotelDTO> paginationResponseDTO = hotelService.search(requestDTO);
        Assertions.assertFalse(paginationResponseDTO.getData().isEmpty(), "Data response is empty");
    }
}