package com.example.hoangtin_ktgk.controller;

import com.example.hoangtin_ktgk.model.NhanVien;
import com.example.hoangtin_ktgk.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhanviens")
    public String listNhanViens(Model model) {
        List<NhanVien> nhanViens = nhanVienService.findAllNhanViens();
        model.addAttribute("nhanViens", nhanViens);
        return "nhanvien/nhanviens";
    }

    @GetMapping("/nhanviens/new")
    public String showNewForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", nhanVienService.findAllPhongBans());
        return "nhanvien/new_nhanvien";
    }

    @PostMapping("/nhanviens")
    public String saveNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien, @RequestParam("phongBanId") String phongBanId) {
        nhanVienService.saveNhanVien(nhanVien, phongBanId);
        return "redirect:/nhanviens";
    }

    @GetMapping("/nhanviens/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.findNhanVienById(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", nhanVienService.findAllPhongBans());
        return "nhanvien/edit_nhanvien";
    }

    @PostMapping("/nhanviens/{id}")
    public String updateNhanVien(@PathVariable("id") String id, @ModelAttribute("nhanVien") NhanVien nhanVien, @RequestParam("phongBanId") String phongBanId) {
        nhanVien.setMaNV(id);
        nhanVienService.saveNhanVien(nhanVien, phongBanId);
        return "redirect:/nhanviens";
    }

    @GetMapping("/nhanviens/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }
}