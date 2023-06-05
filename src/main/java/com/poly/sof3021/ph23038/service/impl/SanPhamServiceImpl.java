package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.SanPham;
import com.poly.sof3021.ph23038.repository.SanPhamRepository;
import com.poly.sof3021.ph23038.service.SanPhamSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamSevice {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> phanTrangSanPham(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteSanPham(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham detailSanPham(UUID id) {
        return sanPhamRepository.findSanPhamById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return sanPhamRepository.existsByMa(ma);
    }
}
