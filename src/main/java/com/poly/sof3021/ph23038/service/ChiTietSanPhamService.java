package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    List<ChiTietSanPham> getAll();

    Page<ChiTietSanPham> phanTrangChiTietSanPham(Pageable pageable);

    void addChiTietSanPham(ChiTietSanPham chiTietSanPham);

    void updateChiTietSanPham(ChiTietSanPham chiTietSanPham);

    void deleteChiTietSanPham(UUID id);

    ChiTietSanPham detailChiTietSanPham(UUID id);

    Boolean checkSanphamTonTai(ChiTietSanPham chiTietSanPham);

}
