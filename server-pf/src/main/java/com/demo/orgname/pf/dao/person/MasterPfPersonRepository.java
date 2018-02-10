package com.demo.orgname.pf.dao.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MasterPfPersonRepository extends CrudRepository<MasterPfPerson, Long> {
	
	// select m.name, c.contractor_labours_wage from master_pf_person m, contractor_labour_wage c where m.munshi_code="M005" and c.contractor_code="M005";
	
	//@Query(name = [name], nativeQuery = true)
	//List<Object[]> methodThatQueriesMultipleTables();

    List<MasterPfPerson> findByName(String name);
}
