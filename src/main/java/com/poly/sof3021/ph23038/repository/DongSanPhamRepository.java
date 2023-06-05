package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSanPham, UUID> {

    DongSanPham findDongSanPhamById(UUID id);

    Boolean existsByMa(String ma);

}
