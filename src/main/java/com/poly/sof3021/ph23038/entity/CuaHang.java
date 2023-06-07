package com.poly.sof3021.ph23038.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cua_hang")
public class CuaHang {

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

    @NotBlank(message = "Không được để trống địa chỉ")
    @Column(name = "dia_chi")
    private String diaChi;

    @NotBlank(message = "Không được để trống thành phố")
    @Column(name = "thanh_pho")
    private String thanhPho;

    @NotBlank(message = "Không được để trống quốc gia")
    @Column(name = "quoc_gia")
    private String quocGia;

}
