package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamSevice {

    List<SanPham> getAll();

    Page<SanPham> phanTrangSanPham(Pageable pageable);

    void addSanPham(SanPham sanPham);

    void updateSanPham(SanPham sanPham);

    void deleteSanPham(UUID id);

    SanPham detailSanPham(UUID id);

    Boolean checkMa(String ma);

}
