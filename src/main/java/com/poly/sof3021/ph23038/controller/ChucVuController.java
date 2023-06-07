package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.ChucVu;
import com.poly.sof3021.ph23038.service.ChucVuService;
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
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/chuc-vu/view-all")
    public String viewAllChucVu(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChucVu> pageChucVu = chucVuService.phanTrangChucVu(pageable);
        model.addAttribute("listChucVu", pageChucVu);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("cv", new ChucVu());
        return "chuc-vu/view-all-chuc-vu";
    }

    @PostMapping("/chuc-vu/add")
    public String addChucVu(
            @Valid @ModelAttribute("cv") ChucVu cv,
            BindingResult result,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Boolean checkMa = chucVuService.checkMa(cv.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa) {
                model.addAttribute("errorMa", "Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<ChucVu> pageChucVu = chucVuService.phanTrangChucVu(pageable);
            model.addAttribute("listChucVu", pageChucVu);
            model.addAttribute("pageNo", pageNo);
            return "chuc-vu/view-all-chuc-vu";
        }
        chucVuService.addChucVu(cv);
        return "redirect:/chuc-vu/view-all";
    }

    @GetMapping("/chuc-vu/remove/{id}")
    public String deleteChucVu(
            @PathVariable("id") String id
    ) {
        chucVuService.deleteChucVu(UUID.fromString(id));
        return "redirect:/chuc-vu/view-all";
    }

    @GetMapping("/chuc-vu/detail/{id}")
    public String detailChucVu(
            @PathVariable("id") String id,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChucVu> pageChucVu = chucVuService.phanTrangChucVu(pageable);
        model.addAttribute("listChucVu", pageChucVu);
        ChucVu cv = chucVuService.detailChucVu(UUID.fromString(id));
        model.addAttribute("cv", cv);
        model.addAttribute("pageNo", pageNo);
        return "chuc-vu/view-all-chuc-vu";
    }

    @GetMapping("/chuc-vu/view-update/{id}")
    public String viewUpdateChucVu(
            @PathVariable("id") String id,
            Model model
    ) {
        ChucVu cv = chucVuService.detailChucVu(UUID.fromString(id));
        model.addAttribute("cv", cv);
        return "chuc-vu/view-update-chuc-vu";
    }

    @PostMapping("/chuc-vu/update/{id}")
    public String updateChucVu(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("cv") ChucVu cv,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "chuc-vu/view-update-chuc-vu";
        }
        chucVuService.updateChucVu(cv);
        return "redirect:/chuc-vu/view-all";
    }

}
