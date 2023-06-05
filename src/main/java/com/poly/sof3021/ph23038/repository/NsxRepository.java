package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NsxRepository extends JpaRepository<Nsx, UUID> {

    Nsx findNsxById(UUID id);

    Boolean existsByMa(String ma);

}
