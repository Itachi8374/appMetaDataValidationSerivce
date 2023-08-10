package com.appMetaDataValidationService.repositories;

import com.appMetaDataValidationService.models.App;
import com.appMetaDataValidationService.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppRepository extends JpaRepository<App, Long> {
    public List<App> findByPublisher(Publisher publisher);
}
