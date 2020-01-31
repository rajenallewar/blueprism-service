package com.syne.api.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syne.api.model.VenueDetail;

@Repository
public interface VenueDetailsRepository extends CrudRepository<VenueDetail, Long> {
//	Optional<VenueDetail> findById(Long shortCode);
}
