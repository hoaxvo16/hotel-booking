package com.hoaxvo.hrs.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "check_in_date")
    private ZonedDateTime checkInDate;

    @Column(name = "check_out_date")
    private ZonedDateTime checkOutDate;

    @Column(name = "price")
    private Long price;

    @Column(name = "is_canceled")
    private boolean isCanceled;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reservation", orphanRemoval = true)
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "room_id", unique = true)
    private Room room;
}
