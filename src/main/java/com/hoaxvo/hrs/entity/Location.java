package com.hoaxvo.hrs.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "location")
    private Set<Hotel> hotels = new LinkedHashSet<>();

}
