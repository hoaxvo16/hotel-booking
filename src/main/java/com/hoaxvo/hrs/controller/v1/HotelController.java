package com.hoaxvo.hrs.controller.v1;

import com.hoaxvo.hrs.dto.HotelDTO;
import com.hoaxvo.hrs.dto.common.PaginationResponseDTO;
import com.hoaxvo.hrs.dto.request.SearchHotelRequestDTO;
import com.hoaxvo.hrs.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hotels")
@RequiredArgsConstructor
@Tag(name = "Hotel API")
public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/search")
    @Operation(summary = "Search hotel")
    public PaginationResponseDTO<HotelDTO> search(@RequestBody SearchHotelRequestDTO requestDTO) {
        return hotelService.search(requestDTO);
    }
}
