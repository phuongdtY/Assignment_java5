package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    Page<MauSac> phanTrangMauSac(Pageable pageable);

    void addMauSac(MauSac mauSac);

    void updateMauSac(MauSac mauSac);

    void deleteMauSac(UUID id);

    MauSac detailMauSac(UUID id);

    Boolean checkMa(String ma);

}
