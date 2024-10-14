package com.web.Repository;

import com.web.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Booking,Long>
{
}
