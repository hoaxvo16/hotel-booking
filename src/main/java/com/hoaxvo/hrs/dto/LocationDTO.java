package com.hoaxvo.hrs.dto;

import com.hoaxvo.hrs.entity.Location;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * DTO for {@link Location}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationDTO implements Serializable {
    @Schema(example = "LOC001")
    private String code;
    @Schema(example = "New York")
    private String city;
    @Schema(example = "New York")
    private String state;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}