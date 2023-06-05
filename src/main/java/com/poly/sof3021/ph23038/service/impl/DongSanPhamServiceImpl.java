package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.DongSanPham;
import com.poly.sof3021.ph23038.repository.DongSanPhamRepository;
import com.poly.sof3021.ph23038.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAll() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public Page<DongSanPham> phanTrangDongSanPham(Pageable pageable) {
        return dongSanPhamRepository.findAll(pageable);
    }

    @Override
    public void addDongSanPham(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void updateDongSanPham(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void deleteDongSanPham(UUID id) {
        dongSanPhamRepository.deleteById(id);
    }

    @Override
    public DongSanPham detailDongSanPham(UUID id) {
        return dongSanPhamRepository.findDongSanPhamById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return dongSanPhamRepository.existsByMa(ma);
    }
}
