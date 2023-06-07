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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "nhan_vien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "Không được để trống mã")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Không được để trống tên")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Không được để trống tên đệm")
    @Column(name = "ten_dem")
    private String tenDem;

    @NotBlank(message = "Không được để trống họ")
    @Column(name = "ho")
    private String ho;

    @NotBlank(message = "Không được để trống giới tính")
    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @NotNull(message = "Không được để trống ngày sinh")
    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @NotBlank(message = "Không được để trống địa chỉ")
    @Column(name = "dia_chi")
    private String diaChi;

    @NotBlank(message = "Không được để trống số điện thoại")
    @Column(name = "sdt")
    private String soDienThoai;

    @NotBlank(message = "Không được để trống mật khẩu")
    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCH", referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCV", referencedColumnName = "id")
    private ChucVu chucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGuiBC", referencedColumnName = "id")
    private NhanVien nhanVien;

    @Column(name = "trang_thai")
    private Integer trangThai;

    public Integer tuoiNhanVien() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = ngaySinh.toLocalDate();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

}
