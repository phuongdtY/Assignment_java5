package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.NhanVien;
import com.poly.sof3021.ph23038.service.ChucVuService;
import com.poly.sof3021.ph23038.service.CuaHangService;
import com.poly.sof3021.ph23038.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/nhan-vien/view-all")
    public String viewAllNhanVien(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhanVien> pageNhanVien = nhanVienService.phanTrangNhanVien(pageable);
        model.addAttribute("listNhanVien", pageNhanVien);
        model.addAttribute("listChucVu", chucVuService.getAll());
        model.addAttribute("listCuaHang", cuaHangService.getAll());
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("nv", new NhanVien());
        return "nhan-vien/view-all-nhan-vien";
    }

    @PostMapping("/nhan-vien/add")
    public String addNhanVien(
            @Valid @ModelAttribute("nv") NhanVien nv,
            BindingResult result,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Boolean checkMa = nhanVienService.checkMa(nv.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa) {
                model.addAttribute("errorMa", "Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<NhanVien> pageNhanVien = nhanVienService.phanTrangNhanVien(pageable);
            model.addAttribute("listNhanVien", pageNhanVien);
            model.addAttribute("listChucVu", chucVuService.getAll());
            model.addAttribute("listCuaHang", cuaHangService.getAll());
            model.addAttribute("pageNo", pageNo);
            return "nhan-vien/view-all-nhan-vien";
        }
        nhanVienService.addNhanVien(nv);
        return "redirect:/nhan-vien/view-all";
    }

    @GetMapping("/nhan-vien/remove/{id}")
    public String deleteNhanVien(
            @PathVariable("id") String id
    ) {
        nhanVienService.deleteNhanVien(UUID.fromString(id));
        return "redirect:/nhan-vien/view-all";
    }

    @GetMapping("/nhan-vien/detail/{id}")
    public String detailNhanVien(
            @PathVariable("id") String id,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhanVien> pageNhanVien = nhanVienService.phanTrangNhanVien(pageable);
        model.addAttribute("listNhanVien", pageNhanVien);
        model.addAttribute("listChucVu", chucVuService.getAll());
        model.addAttribute("listCuaHang", cuaHangService.getAll());
        NhanVien nv = nhanVienService.detailNhanVien(UUID.fromString(id));
        model.addAttribute("nv", nv);
        model.addAttribute("pageNo", pageNo);
        return "nhan-vien/view-all-nhan-vien";
    }

    @GetMapping("/nhan-vien/view-update/{id}")
    public String viewUpdateNhanVien(
            @PathVariable("id") String id,
            Model model
    ) {
        NhanVien nv = nhanVienService.detailNhanVien(UUID.fromString(id));
        model.addAttribute("listChucVu", chucVuService.getAll());
        model.addAttribute("listCuaHang", cuaHangService.getAll());
        model.addAttribute("nv", nv);
        return "nhan-vien/view-update-nhan-vien";
    }

    @PostMapping("/nhan-vien/update/{id}")
    public String updateNhanVien(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("nv") NhanVien nv,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("listChucVu", chucVuService.getAll());
            model.addAttribute("listCuaHang", cuaHangService.getAll());
            return "nhan-vien/view-update-nhan-vien";
        }
        nhanVienService.updateNhanVien(nv);
        return "redirect:/nhan-vien/view-all";
    }

}
