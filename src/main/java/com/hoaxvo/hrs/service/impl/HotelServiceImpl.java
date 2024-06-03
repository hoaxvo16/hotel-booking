package com.hoaxvo.hrs.service.impl;

import com.hoaxvo.hrs.dto.HotelDTO;
import com.hoaxvo.hrs.dto.common.PaginationResponseDTO;
import com.hoaxvo.hrs.dto.request.SearchHotelRequestDTO;
import com.hoaxvo.hrs.entity.Hotel;
import com.hoaxvo.hrs.mapper.HotelMapper;
import com.hoaxvo.hrs.repositoriy.HotelRepository;
import com.hoaxvo.hrs.service.HotelService;
import com.hoaxvo.hrs.util.QueryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public PaginationResponseDTO<HotelDTO> search(SearchHotelRequestDTO requestDTO) {
        Page<Hotel> hotelPage = hotelRepository.
                searchHotelByLocation(requestDTO.getCity(), requestDTO.getState(), QueryUtils.createPageable(requestDTO));
        List<HotelDTO> hotelDTOs = hotelMapper.toDTOs(hotelPage.getContent());
        return QueryUtils.createPaginationResponse(requestDTO, hotelDTOs, hotelPage.getTotalPages());
    }

}
