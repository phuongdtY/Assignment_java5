package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.MauSac;
import com.poly.sof3021.ph23038.service.MauSacService;
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
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/mau-sac/view-all")
    public String viewAllMauSac(Model model, @RequestParam(name="page", defaultValue = "0")Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo,5);
        Page<MauSac> pageMauSac = mauSacService.phanTrangMauSac(pageable);
        model.addAttribute("listMauSac", pageMauSac);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("ms", new MauSac());
        return "mau-sac/view-all-mau-sac";
    }

    @PostMapping("/mau-sac/add")
    public String addMauSac(
            @Valid @ModelAttribute("ms")MauSac ms,
            BindingResult result,
            Model model,
            @RequestParam(name="page", defaultValue = "0")Integer pageNo
    ) {
        Boolean checkMa = mauSacService.checkMa(ms.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa){
                model.addAttribute("errorMa","Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo,5);
            Page<MauSac> pageMauSac = mauSacService.phanTrangMauSac(pageable);
            model.addAttribute("listMauSac", pageMauSac);
            model.addAttribute("pageNo", pageNo);
            return "mau-sac/view-all-mau-sac";
        }
        mauSacService.addMauSac(ms);
        return "redirect:/mau-sac/view-all";
    }

    @GetMapping("/mau-sac/remove/{id}")
    public String deleteMauSac(
            @PathVariable("id")String id
    ){
        mauSacService.deleteMauSac(UUID.fromString(id));
        return "redirect:/mau-sac/view-all";
    }

    @GetMapping("/mau-sac/detail/{id}")
    public String detailMauSac(
            @PathVariable("id")String id,
            Model model,
            @RequestParam(name="page", defaultValue = "0")Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo,5);
        Page<MauSac> pageMauSac = mauSacService.phanTrangMauSac(pageable);
        model.addAttribute("listMauSac", pageMauSac);
        MauSac ms = mauSacService.detailMauSac(UUID.fromString(id));
        model.addAttribute("ms",ms);
        model.addAttribute("pageNo",pageNo);
        return "mau-sac/view-all-mau-sac";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String viewUpdateMauSac(
            @PathVariable("id")String id,
            Model model
    ){
        MauSac ms = mauSacService.detailMauSac(UUID.fromString(id));
        model.addAttribute("ms",ms);
        return "mau-sac/view-update-mau-sac";
    }

    @PostMapping("/mau-sac/update/{id}")
    public String updateMauSac(
            @PathVariable("id")String id,
            @Valid @ModelAttribute("ms")MauSac ms,
            BindingResult result
    ){
        if (result.hasErrors()) {
            return "mau-sac/view-update-mau-sac";
        }
        mauSacService.updateMauSac(ms);
        return "redirect:/mau-sac/view-all";
    }

}
