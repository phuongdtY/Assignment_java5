package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    NhanVien findNhanVienById(UUID id);

    Boolean existsByMa(String ma);

}
