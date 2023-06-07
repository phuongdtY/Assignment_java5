package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.ChiTietSanPham;
import com.poly.sof3021.ph23038.service.ChiTietSanPhamService;
import com.poly.sof3021.ph23038.service.DongSanPhamService;
import com.poly.sof3021.ph23038.service.MauSacService;
import com.poly.sof3021.ph23038.service.NsxService;
import com.poly.sof3021.ph23038.service.SanPhamSevice;
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
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private SanPhamSevice sanPhamSevice;

    @Autowired
    private NsxService nsxService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("/chi-tiet-san-pham/view-all")
    public String viewAllChiTietSanPham(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChiTietSanPham> pageChiTietSanPham = chiTietSanPhamService.phanTrangChiTietSanPham(pageable);
        model.addAttribute("listChiTietSanPham", pageChiTietSanPham);
        model.addAttribute("listSanPham", sanPhamSevice.getAll());
        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMauSac", mauSacService.getAll());
        model.addAttribute("listDongSanPham", dongSanPhamService.getAll());
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("ctsp", new ChiTietSanPham());
        return "chi-tiet-san-pham/view-all-chi-tiet-san-pham";
    }

    @PostMapping("/chi-tiet-san-pham/add")
    public String addChiTietSanPham(
            @Valid @ModelAttribute("ctsp") ChiTietSanPham ctsp,
            BindingResult result,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Boolean checkTontai = chiTietSanPhamService.checkSanphamTonTai(ctsp);
        if (result.hasErrors() || checkTontai) {
            if (checkTontai) {
                model.addAttribute("errorTonTai", "Sản phẩm này đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<ChiTietSanPham> pageChiTietSanPham = chiTietSanPhamService.phanTrangChiTietSanPham(pageable);
            model.addAttribute("listChiTietSanPham", pageChiTietSanPham);
            model.addAttribute("listSanPham", sanPhamSevice.getAll());
            model.addAttribute("listNsx", nsxService.getAll());
            model.addAttribute("listMauSac", mauSacService.getAll());
            model.addAttribute("listDongSanPham", dongSanPhamService.getAll());
            model.addAttribute("pageNo", pageNo);
            return "chi-tiet-san-pham/view-all-chi-tiet-san-pham";
        }
        chiTietSanPhamService.addChiTietSanPham(ctsp);
        return "redirect:/chi-tiet-san-pham/view-all";
    }

    @GetMapping("/chi-tiet-san-pham/remove/{id}")
    public String deleteChiTietSanPham(
            @PathVariable("id") String id
    ) {
        chiTietSanPhamService.deleteChiTietSanPham(UUID.fromString(id));
        return "redirect:/chi-tiet-san-pham/view-all";
    }

    @GetMapping("/chi-tiet-san-pham/detail/{id}")
    public String detailChiTietSanPham(
            @PathVariable("id") String id,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChiTietSanPham> pageChiTietSanPham = chiTietSanPhamService.phanTrangChiTietSanPham(pageable);
        model.addAttribute("listChiTietSanPham", pageChiTietSanPham);
        model.addAttribute("listSanPham", sanPhamSevice.getAll());
        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMauSac", mauSacService.getAll());
        model.addAttribute("listDongSanPham", dongSanPhamService.getAll());
        ChiTietSanPham ctsp = chiTietSanPhamService.detailChiTietSanPham(UUID.fromString(id));
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("pageNo", pageNo);
        return "chi-tiet-san-pham/view-all-chi-tiet-san-pham";
    }

    @GetMapping("/chi-tiet-san-pham/view-update/{id}")
    public String viewUpdateChiTietSanPham(
            @PathVariable("id") String id,
            Model model
    ) {
        model.addAttribute("listSanPham", sanPhamSevice.getAll());
        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMauSac", mauSacService.getAll());
        model.addAttribute("listDongSanPham", dongSanPhamService.getAll());
        ChiTietSanPham ctsp = chiTietSanPhamService.detailChiTietSanPham(UUID.fromString(id));
        model.addAttribute("ctsp", ctsp);
        return "chi-tiet-san-pham/view-update-chi-tiet-san-pham";
    }

    @PostMapping("/chi-tiet-san-pham/update/{id}")
    public String updateChiTietSanPham(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("ctsp") ChiTietSanPham ctsp,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("listSanPham", sanPhamSevice.getAll());
            model.addAttribute("listNsx", nsxService.getAll());
            model.addAttribute("listMauSac", mauSacService.getAll());
            model.addAttribute("listDongSanPham", dongSanPhamService.getAll());
            return "chi-tiet-san-pham/view-update-chi-tiet-san-pham";
        }
        chiTietSanPhamService.updateChiTietSanPham(ctsp);
        return "redirect:/chi-tiet-san-pham/view-all";
    }

}
