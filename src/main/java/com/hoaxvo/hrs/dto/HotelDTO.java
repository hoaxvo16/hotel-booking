package com.hoaxvo.hrs.dto;

import com.hoaxvo.hrs.entity.Hotel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * DTO for {@link Hotel}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO implements Serializable {
    private Long id;
    @Schema(example = "Hotel A")
    private String name;
    @Schema(example = "HOTEL001")
    private String code;
    @Schema(example = "123-456-78900")
    private String phoneNumber;
    @Schema(example = "contact@hotela1.com")
    private String email;
    private Boolean isAvailable;
    private LocationDTO location;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}