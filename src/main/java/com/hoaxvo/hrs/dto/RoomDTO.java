package com.hoaxvo.hrs.dto;

import com.hoaxvo.hrs.entity.Room;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Room}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO implements Serializable {
    private Long id;
    private Integer capacity;
    private String roomNumber;
    private String type;
    private Long pricePerNight;
    private String currency;
}