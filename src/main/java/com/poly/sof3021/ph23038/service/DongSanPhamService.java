package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSanPham> getAll();

    Page<DongSanPham> phanTrangDongSanPham(Pageable pageable);

    void addDongSanPham(DongSanPham dongSanPham);

    void updateDongSanPham(DongSanPham dongSanPham);

    void deleteDongSanPham(UUID id);

    DongSanPham detailDongSanPham(UUID id);

    Boolean checkMa(String ma);


}
