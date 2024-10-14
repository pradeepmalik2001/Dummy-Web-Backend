package com.web.Repository;

import com.web.Entity.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SlotsRepository extends JpaRepository<Slots,Long> {
}
