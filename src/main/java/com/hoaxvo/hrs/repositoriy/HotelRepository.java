package com.hoaxvo.hrs.repositoriy;

import com.hoaxvo.hrs.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {
    @Query(value = "select h from Hotel h where h.location.city like %:city% and h.location.state like %:state%")
    Page<Hotel> searchHotelByLocation(@Param("city") String city, @Param("state") String state, Pageable pageable);
}