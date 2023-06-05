package com.poly.sof3021.ph23038.service.impl;

import com.poly.sof3021.ph23038.entity.Nsx;
import com.poly.sof3021.ph23038.repository.NsxRepository;
import com.poly.sof3021.ph23038.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NsxServiceImpl implements NsxService {

    @Autowired
    private NsxRepository nsxRepository;

    @Override
    public List<Nsx> getAll() {
        return nsxRepository.findAll();
    }

    @Override
    public Page<Nsx> phanTrangNsx(Pageable pageable) {
        return nsxRepository.findAll(pageable);
    }

    @Override
    public void addNsx(Nsx nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public void updateNsx(Nsx nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public void deleteNsx(UUID id) {
        nsxRepository.deleteById(id);
    }

    @Override
    public Nsx detailNsx(UUID id) {
        return nsxRepository.findNsxById(id);
    }

    @Override
    public Boolean checkMa(String ma) {
        return nsxRepository.existsByMa(ma);
    }


}
