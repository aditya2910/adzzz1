package com.demo.orgname.dao.dataentry.rawmaterialinward;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RawMaterialInwardDataEntryMasterRepository extends CrudRepository<RawMaterialInwardDataEntryMaster, String> {

}
