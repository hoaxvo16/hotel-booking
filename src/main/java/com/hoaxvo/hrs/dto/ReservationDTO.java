package com.hoaxvo.hrs.dto;

import com.hoaxvo.hrs.entity.Reservation;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * DTO for {@link Reservation}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO implements Serializable {
    private Long id;
    private ZonedDateTime checkInDate;
    private ZonedDateTime checkOutDate;
    private Long price;
    private boolean isCanceled;
    private String cancelReason;
    private GuestDTO guest;
    private RoomDTO room;
}