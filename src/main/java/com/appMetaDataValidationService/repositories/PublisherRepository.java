package com.appMetaDataValidationService.repositories;

import com.appMetaDataValidationService.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
