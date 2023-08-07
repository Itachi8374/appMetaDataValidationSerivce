package com.appMetaDataValidationService.repositories;

import com.appMetaDataValidationService.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}
