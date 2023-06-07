package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAll();

    Page<CuaHang> phanTrangCuaHang(Pageable pageable);

    void addCuaHang(CuaHang cuaHang);

    void updateCuaHang(CuaHang cuaHang);

    void deleteCuaHang(UUID id);

    CuaHang detailCuaHang(UUID id);

    Boolean checkMa(String ma);

}
