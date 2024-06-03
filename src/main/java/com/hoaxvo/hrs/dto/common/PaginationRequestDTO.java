package com.hoaxvo.hrs.dto.common;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationRequestDTO implements Serializable {
    private Integer page;
    private Integer limit;
    private List<String> orders = new ArrayList<>();
    private Sort.Direction sortDirection = Sort.Direction.ASC;
}
