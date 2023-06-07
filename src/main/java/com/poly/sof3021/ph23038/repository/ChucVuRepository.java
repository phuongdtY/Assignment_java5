package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {

    ChucVu findChucVuById(UUID id);

    Boolean existsByMa(String ma);

}
