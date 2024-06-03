package com.hoaxvo.hrs.dto;

import com.hoaxvo.hrs.entity.User;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GuestDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}