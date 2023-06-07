package com.poly.sof3021.ph23038.controller;

import com.poly.sof3021.ph23038.entity.Nsx;
import com.poly.sof3021.ph23038.service.NsxService;
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
public class NsxController {

    @Autowired
    private NsxService nsxService;

    @GetMapping("/nsx/view-all")
    public String viewAllNsx(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<Nsx> listNsx = nsxService.phanTrangNsx(pageable);
        model.addAttribute("listNsx", listNsx);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("nsx", new Nsx());
        return "nsx/view-all-nsx";
    }

    @PostMapping("/nsx/add")
    public String addNsx(
            @Valid @ModelAttribute("nsx") Nsx nsx,
            BindingResult result,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Boolean checkMa = nsxService.checkMa(nsx.getMa());
        if (result.hasErrors() || checkMa) {
            if (checkMa) {
                model.addAttribute("errorMa", "Mã đã tồn tại");
            }
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<Nsx> listNsx = nsxService.phanTrangNsx(pageable);
            model.addAttribute("listNsx", listNsx);
            model.addAttribute("pageNo", pageNo);
            return "nsx/view-all-nsx";
        }
        nsxService.addNsx(nsx);
        return "redirect:/nsx/view-all";
    }

    @GetMapping("/nsx/remove/{id}")
    public String deleteNsx(
            @PathVariable("id") String id
    ) {
        nsxService.deleteNsx(UUID.fromString(id));
        return "redirect:/nsx/view-all";
    }

    @GetMapping("/nsx/detail/{id}")
    public String detailNsx(
            @PathVariable("id") String id,
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<Nsx> listNsx = nsxService.phanTrangNsx(pageable);
        Nsx nsx = nsxService.detailNsx(UUID.fromString(id));
        model.addAttribute("nsx", nsx);
        model.addAttribute("listNsx", listNsx);
        model.addAttribute("pageNo", pageNo);
        return "nsx/view-all-nsx";
    }

    @GetMapping("/nsx/view-update/{id}")
    public String viewUpdateNsx(
            @PathVariable("id") String id,
            Model model
    ) {
        Nsx nsx = nsxService.detailNsx(UUID.fromString(id));
        model.addAttribute("nsx", nsx);
        return "nsx/view-update-nsx";
    }

    @PostMapping("/nsx/update/{id}")
    public String updateNsx(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("nsx") Nsx nsx,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "nsx/view-update-nsx";
        }
        nsxService.updateNsx(nsx);
        return "redirect:/nsx/view-all";
    }

}
