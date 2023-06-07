package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.ChucVu;
import com.poly.sof3021.ph23038.repository.ChucVuRepository;
import com.poly.sof3021.ph23038.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public Page<ChucVu> phanTrangChucVu(Pageable pageable) {
        return chucVuRepository.findAll(pageable);
    }

    @Override
    public void addChucVu(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void updateChucVu(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void deleteChucVu(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu detailChucVu(UUID id) {
        return chucVuRepository.findChucVuById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return chucVuRepository.existsByMa(ma);
    }
}
