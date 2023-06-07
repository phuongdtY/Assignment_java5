package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.NhanVien;
import com.poly.sof3021.ph23038.repository.NhanVienRepository;
import com.poly.sof3021.ph23038.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public Page<NhanVien> phanTrangNhanVien(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public void addNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNhanVien(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien detailNhanVien(UUID id) {
        return nhanVienRepository.findNhanVienById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return nhanVienRepository.existsByMa(ma);
    }
}
