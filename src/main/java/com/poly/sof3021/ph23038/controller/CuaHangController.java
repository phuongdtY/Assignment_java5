package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.CuaHang;
import com.poly.sof3021.ph23038.service.CuaHangService;
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
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/cua-hang/view-all")
    public String viewAllCuaHang(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<CuaHang> pageCuaHang = cuaHangService.phanTrangCuaHang(pageable);
        model.addAttribute("listCuaHang", pageCuaHang);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("ch", new CuaHang());
        return "cua-hang/view-all-cua-hang";
    }

    @PostMapping("/cua-hang/add")
    public String addCuaHang(
            @Valid @ModelAttribute("ch") CuaHang ch,
            BindingResult result,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Boolean checkMa = cuaHangService.checkMa(ch.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa) {
                model.addAttribute("errorMa", "Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<CuaHang> pageCuaHang = cuaHangService.phanTrangCuaHang(pageable);
            model.addAttribute("listCuaHang", pageCuaHang);
            model.addAttribute("pageNo", pageNo);
            return "cua-hang/view-all-cua-hang";
        }
        cuaHangService.addCuaHang(ch);
        return "redirect:/cua-hang/view-all";
    }

    @GetMapping("/cua-hang/remove/{id}")
    public String deleteCuaHang(
            @PathVariable("id") String id
    ) {
        cuaHangService.deleteCuaHang(UUID.fromString(id));
        return "redirect:/cua-hang/view-all";
    }

    @GetMapping("/cua-hang/detail/{id}")
    public String detailCuaHang(
            @PathVariable("id") String id,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<CuaHang> pageCuaHang = cuaHangService.phanTrangCuaHang(pageable);
        model.addAttribute("listCuaHang", pageCuaHang);
        CuaHang ch = cuaHangService.detailCuaHang(UUID.fromString(id));
        model.addAttribute("ch", ch);
        model.addAttribute("pageNo", pageNo);
        return "cua-hang/view-all-cua-hang";
    }

    @GetMapping("/cua-hang/view-update/{id}")
    public String viewUpdateCuaHang(
            @PathVariable("id") String id,
            Model model
    ) {
        CuaHang ch = cuaHangService.detailCuaHang(UUID.fromString(id));
        model.addAttribute("ch", ch);
        return "cua-hang/view-update-cua-hang";
    }

    @PostMapping("/cua-hang/update/{id}")
    public String updateCuaHang(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("ch") CuaHang ch,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "cua-hang/view-update-cua-hang";
        }
        cuaHangService.updateCuaHang(ch);
        return "redirect:/cua-hang/view-all";
    }

}
