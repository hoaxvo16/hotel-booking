package com.hoaxvo.hrs.util;

import com.hoaxvo.hrs.dto.common.PaginationRequestDTO;
import com.hoaxvo.hrs.dto.common.PaginationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class QueryUtils {
    public static Pageable createPageable(PaginationRequestDTO requestDTO) {
        List<Sort.Order> orders = new ArrayList<>();
        for (String order : requestDTO.getOrders()) {
            if (requestDTO.getSortDirection() == null || requestDTO.getSortDirection().isAscending()) {
                orders.add(Sort.Order.asc(order));
            } else {
                orders.add(Sort.Order.desc(order));
            }
        }
        Sort sort = orders.isEmpty() ? Sort.unsorted() : Sort.by(orders);
        return PageRequest.of(requestDTO.getPage(), requestDTO.getLimit(), sort);
    }

    public static <T> PaginationResponseDTO<T> createPaginationResponse(PaginationRequestDTO requestDTO, List<T> data,
                                                                        long totalPages) {
        PaginationResponseDTO<T> paginationResponseDTO = new PaginationResponseDTO<>();
        paginationResponseDTO.setData(data);
        paginationResponseDTO.setPage(requestDTO.getPage());
        paginationResponseDTO.setLimit(requestDTO.getLimit());
        paginationResponseDTO.setTotalPages(totalPages);
        paginationResponseDTO.setData(data);
        return paginationResponseDTO;
    }

    private QueryUtils() {

    }
}
