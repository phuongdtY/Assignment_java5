package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {

    MauSac findMauSacById(UUID id);

    Boolean existsByMa(String ma);

}
