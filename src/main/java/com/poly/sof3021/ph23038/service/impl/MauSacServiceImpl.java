package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.MauSac;
import com.poly.sof3021.ph23038.repository.MauSacRepository;
import com.poly.sof3021.ph23038.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public Page<MauSac> phanTrangMauSac(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public void addMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void updateMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void deleteMauSac(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public MauSac detailMauSac(UUID id) {
        return mauSacRepository.findMauSacById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return mauSacRepository.existsByMa(ma);
    }
}
