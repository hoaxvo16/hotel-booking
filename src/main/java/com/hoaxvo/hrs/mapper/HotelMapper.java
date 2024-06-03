package com.hoaxvo.hrs.mapper;

import com.hoaxvo.hrs.dto.HotelDTO;
import com.hoaxvo.hrs.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HotelMapper {
    HotelDTO toDTO(Hotel hotel);

    List<HotelDTO> toDTOs(List<Hotel> hotels);
}
