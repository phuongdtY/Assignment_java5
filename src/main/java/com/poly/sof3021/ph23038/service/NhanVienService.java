package com.poly.sof3021.ph23038.service;


import com.poly.sof3021.ph23038.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAll();

    Page<NhanVien> phanTrangNhanVien(Pageable pageable);

    void addNhanVien(NhanVien nhanVien);

    void updateNhanVien(NhanVien nhanVien);

    void deleteNhanVien(UUID id);

    NhanVien detailNhanVien(UUID id);

    Boolean checkMa(String ma);

}
