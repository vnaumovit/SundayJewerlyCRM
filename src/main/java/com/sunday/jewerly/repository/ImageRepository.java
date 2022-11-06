package com.sunday.jewerly.repository;

import com.sunday.jewerly.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image,UUID> {

    @Transactional
    Optional<Image> findByItemId(UUID itemId);
}