package com.poly.sof3021.ph23038.repository;

import com.poly.sof3021.ph23038.entity.ChiTietSanPham;
import com.poly.sof3021.ph23038.entity.DongSanPham;
import com.poly.sof3021.ph23038.entity.MauSac;
import com.poly.sof3021.ph23038.entity.Nsx;
import com.poly.sof3021.ph23038.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {

    ChiTietSanPham findChiTietSanPhamById(UUID id);

    Boolean existsBySanPhamAndNsxAndDongSanPhamAndMauSac(SanPham sanPham, Nsx nsx, DongSanPham dongSanPham, MauSac mauSac);

    @Query("SELECT CASE WHEN COUNT(ctsp) > 0 THEN TRUE ELSE FALSE END FROM ChiTietSanPham ctsp WHERE ctsp.sanPham.id = ?1 AND ctsp.mauSac.id = ?2 AND ctsp.dongSanPham.id = ?3 AND ctsp.nsx.id = ?4")
    boolean existsChiTietSanPham(UUID idSanPham, UUID idMauSac, UUID idDongSanPham, UUID idNsx);


}
