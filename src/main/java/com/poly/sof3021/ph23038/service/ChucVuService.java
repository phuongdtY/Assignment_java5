package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getAll();

    Page<ChucVu> phanTrangChucVu(Pageable pageable);

    void addChucVu(ChucVu chucVu);

    void updateChucVu(ChucVu chucVu);

    void deleteChucVu(UUID id);

    ChucVu detailChucVu(UUID id);

    Boolean checkMa(String ma);


}
