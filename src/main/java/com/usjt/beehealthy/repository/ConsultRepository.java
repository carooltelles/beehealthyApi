package com.usjt.beehealthy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.Consult;

public interface ConsultRepository extends JpaRepository<Consult, Long> {
	public Consult findByidconsult(Long id);

	public Consult deleteByidconsult(Long id);
}
