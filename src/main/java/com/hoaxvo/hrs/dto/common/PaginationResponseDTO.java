package com.hoaxvo.hrs.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponseDTO<T> implements Serializable {
    private Integer limit;
    private Integer page;
    private List<String> orders;
    private Sort.Direction sortDirection;
    private Long totalPages;
    private List<T> data;
}
