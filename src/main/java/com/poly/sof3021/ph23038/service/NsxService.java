package com.poly.sof3021.ph23038.service;

import com.poly.sof3021.ph23038.entity.Nsx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NsxService {

    List<Nsx> getAll();

    Page<Nsx> phanTrangNsx(Pageable pageable);

    void addNsx(Nsx nsx);

    void updateNsx(Nsx nsx);

    void deleteNsx(UUID id);

    Nsx detailNsx(UUID id);

    Boolean checkMa(String ma);

}
