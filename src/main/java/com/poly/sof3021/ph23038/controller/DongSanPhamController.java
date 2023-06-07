package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.DongSanPham;
import com.poly.sof3021.ph23038.service.DongSanPhamService;
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
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("/dong-san-pham/view-all")
    public String viewAllDongSanPham(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<DongSanPham> pageDongSanPham = dongSanPhamService.phanTrangDongSanPham(pageable);
        model.addAttribute("listDongSanPham", pageDongSanPham);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("dsp", new DongSanPham());
        return "dong-san-pham/view-all-dong-san-pham";
    }

    @PostMapping("/dong-san-pham/add")
    public String addDongSanPham(
            @Valid @ModelAttribute("dsp") DongSanPham dsp,
            BindingResult result,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Boolean checkMa = dongSanPhamService.checkMa(dsp.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa) {
                model.addAttribute("errorMa", "Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<DongSanPham> pageDongSanPham = dongSanPhamService.phanTrangDongSanPham(pageable);
            model.addAttribute("listDongSanPham", pageDongSanPham);
            model.addAttribute("pageNo", pageNo);
            return "dong-san-pham/view-all-dong-san-pham";
        }
        dongSanPhamService.addDongSanPham(dsp);
        return "redirect:/dong-san-pham/view-all";
    }

    @GetMapping("/dong-san-pham/remove/{id}")
    public String deleteDongSanPham(
            @PathVariable("id") String id
    ) {
        dongSanPhamService.deleteDongSanPham(UUID.fromString(id));
        return "redirect:/dong-san-pham/view-all";
    }

    @GetMapping("/dong-san-pham/detail/{id}")
    public String detailDongSanPham(
            @PathVariable("id") String id,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<DongSanPham> pageDongSanPham = dongSanPhamService.phanTrangDongSanPham(pageable);
        model.addAttribute("listDongSanPham", pageDongSanPham);
        DongSanPham dsp = dongSanPhamService.detailDongSanPham(UUID.fromString(id));
        model.addAttribute("dsp", dsp);
        model.addAttribute("pageNo", pageNo);
        return "dong-san-pham/view-all-dong-san-pham";
    }

    @GetMapping("/dong-san-pham/view-update/{id}")
    public String viewUpdateDongSanPham(
            @PathVariable("id") String id,
            Model model
    ) {
        DongSanPham dsp = dongSanPhamService.detailDongSanPham(UUID.fromString(id));
        model.addAttribute("dsp", dsp);
        return "dong-san-pham/view-update-dong-san-pham";
    }

    @PostMapping("/dong-san-pham/update/{id}")
    public String updateDongSanPham(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("dsp") DongSanPham dsp,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "dong-san-pham/view-update-dong-san-pham";
        }
        dongSanPhamService.updateDongSanPham(dsp);
        return "redirect:/dong-san-pham/view-all";
    }

}
