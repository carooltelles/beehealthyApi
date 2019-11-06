package com.usjt.beehealthy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usjt.beehealthy.model.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
	public Nutritionist findByiduser(Long id);
	
	public Nutritionist findByTypeAndEmail(String type, String email);
	
	public Nutritionist deleteByiduser(Long id);

	public List<Nutritionist> findByFullnameContaining(String fullname);
	
	@Query(value="SELECT u.iduser, u.birthday, u.email, u.fullname, n.crn, n.specialization FROM nutritionist n INNER JOIN user u ON n.iduser = u.iduser WHERE u.fullname like '%?1%'",
			nativeQuery=true)
	public List<Nutritionist> selectByName(String fullname);
}
