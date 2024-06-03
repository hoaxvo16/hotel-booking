package com.hoaxvo.hrs.controller.v1;

import com.hoaxvo.hrs.dto.ReservationDTO;
import com.hoaxvo.hrs.dto.request.CreateReservationRequestDTO;
import com.hoaxvo.hrs.dto.request.EditReservationRequestDTO;
import com.hoaxvo.hrs.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reservations")
@RequiredArgsConstructor
@Tag(name = "Reservation API")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @Operation(summary = "Create reservation")
    public void reserve(@RequestBody CreateReservationRequestDTO requestDTO) {
        reservationService.createReservation(requestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit reservation")
    public void editReserve(@PathVariable Long id, EditReservationRequestDTO requestDTO) {
        reservationService.editReservation(id, requestDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get reservation detail")
    public ReservationDTO getDetail(@PathVariable Long id) {
        return reservationService.getDetail(id);
    }
}
