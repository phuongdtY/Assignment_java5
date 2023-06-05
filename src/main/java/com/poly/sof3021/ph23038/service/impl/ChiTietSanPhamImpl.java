package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.ChiTietSanPham;
import com.poly.sof3021.ph23038.repository.ChiTietSanPhamRepository;
import com.poly.sof3021.ph23038.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> phanTrangChiTietSanPham(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public void addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void updateChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void deleteChiTietSanPham(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public ChiTietSanPham detailChiTietSanPham(UUID id) {
        return chiTietSanPhamRepository.findChiTietSanPhamById(id);
    }

    @Override
    public Boolean checkSanphamTonTai(ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamRepository.existsBySanPhamAndNsxAndDongSanPhamAndMauSac(chiTietSanPham.getSanPham(), chiTietSanPham.getNsx(), chiTietSanPham.getDongSanPham(), chiTietSanPham.getMauSac());
    }

}
