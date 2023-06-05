package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.SanPham;
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
public class SanPhamController {

    @Autowired
    private SanPhamSevice sanPhamSevice;

    @GetMapping("/san-pham/view-all")
    public String viewAllSanPham(Model model, @RequestParam(name="page", defaultValue = "0")Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo,5);
        Page<SanPham> pageSanPham = sanPhamSevice.phanTrangSanPham(pageable);
        model.addAttribute("listSanPham", pageSanPham);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("sp", new SanPham());
        return "san-pham/view-all-san-pham";
    }

    @PostMapping("/san-pham/add")
    public String addSanPham(
            @Valid @ModelAttribute("sp")SanPham sp,
            BindingResult result,
            Model model,
            @RequestParam(name="page", defaultValue = "0")Integer pageNo
    ) {
        Boolean checkMa = sanPhamSevice.checkMa(sp.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa){
                model.addAttribute("errorMa","Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo,5);
            Page<SanPham> pageSanPham = sanPhamSevice.phanTrangSanPham(pageable);
            model.addAttribute("listSanPham", pageSanPham);
            model.addAttribute("pageNo", pageNo);
            return "san-pham/view-all-san-pham";
        }
        sanPhamSevice.addSanPham(sp);
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("/san-pham/remove/{id}")
    public String deleteSanPham(
            @PathVariable("id")String id
    ){
        sanPhamSevice.deleteSanPham(UUID.fromString(id));
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("/san-pham/detail/{id}")
    public String detailSanPham(
            @PathVariable("id")String id,
            Model model,
            @RequestParam(name="page", defaultValue = "0")Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo,5);
        Page<SanPham> pageSanPham = sanPhamSevice.phanTrangSanPham(pageable);
        model.addAttribute("listSanPham", pageSanPham);
        SanPham sp = sanPhamSevice.detailSanPham(UUID.fromString(id));
        model.addAttribute("sp",sp);
        model.addAttribute("pageNo",pageNo);
        return "san-pham/view-all-san-pham";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewUpdateSanPham(
            @PathVariable("id")String id,
            Model model
    ){
        SanPham sp = sanPhamSevice.detailSanPham(UUID.fromString(id));
        model.addAttribute("sp",sp);
        return "san-pham/view-update-san-pham";
    }

    @PostMapping("/san-pham/update/{id}")
    public String updateSanPham(
            @PathVariable("id")String id,
            @Valid @ModelAttribute("sp")SanPham sp,
            BindingResult result
    ){
        if (result.hasErrors()) {
            return "san-pham/view-update-san-pham";
        }
        sanPhamSevice.updateSanPham(sp);
        return "redirect:/san-pham/view-all";
    }

}
