package com.hoaxvo.hrs.mapper;

import com.hoaxvo.hrs.dto.ReservationDTO;
import com.hoaxvo.hrs.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    ReservationDTO toDTO(Reservation reservation);
}
