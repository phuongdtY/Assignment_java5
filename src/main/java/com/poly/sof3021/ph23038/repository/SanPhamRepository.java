package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {

    SanPham findSanPhamById(UUID id);

    Boolean existsByMa(String ma);


}
