package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {

    CuaHang findCuaHangById(UUID id);

    Boolean existsByMa(String ma);

}
