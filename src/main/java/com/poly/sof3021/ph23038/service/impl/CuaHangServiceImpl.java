package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.CuaHang;
import com.poly.sof3021.ph23038.repository.CuaHangRepository;
import com.poly.sof3021.ph23038.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public Page<CuaHang> phanTrangCuaHang(Pageable pageable) {
        return cuaHangRepository.findAll(pageable);
    }

    @Override
    public void addCuaHang(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void updateCuaHang(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void deleteCuaHang(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang detailCuaHang(UUID id) {
        return cuaHangRepository.findCuaHangById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return cuaHangRepository.existsByMa(ma);
    }
}
