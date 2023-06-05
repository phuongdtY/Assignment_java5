package com.poly.sof3021.ph23038.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chi_tiet_san_pham")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSP",referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNsx",referencedColumnName = "id")
    private Nsx nsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMauSac",referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDongSP",referencedColumnName = "id")
    private DongSanPham dongSanPham;

    @NotNull(message = "Không được để trống năm bảo hành")
    @Column(name = "nam_bao_hanh")
    private Integer namBaoHanh;

    @NotBlank(message = "Không được để trống mô tả")
    @Length(max = 50,message = "không được quá 50 kí tự")
    @Column(name = "mo_ta")
    private String moTa;

    @NotNull(message = "Không được để trống số lượng tồn")
    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @NotNull(message = "Không được để trống giá nhập")
    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @NotNull(message = "Không được để trống giá bán")
    @Column(name = "gia_ban")
    private BigDecimal giaBan;

}
