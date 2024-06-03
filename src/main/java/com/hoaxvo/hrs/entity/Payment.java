package com.hoaxvo.hrs.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.ZonedDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "method")
    private String method;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "created_date")
    @CreatedDate
    private ZonedDateTime createdDate;

    @Column(name = "completed_date")
    private ZonedDateTime completedDate;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
