package com.cb.springdata.sample.repositories;

import com.cb.springdata.sample.entities.Building;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "building")
public interface BuildingRepository extends CouchbasePagingAndSortingRepository<Building, String> {

   
}
