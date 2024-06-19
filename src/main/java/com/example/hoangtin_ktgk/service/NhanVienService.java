package com.example.hoangtin_ktgk.service;

import com.example.hoangtin_ktgk.model.NhanVien;
import com.example.hoangtin_ktgk.model.PhongBan;
import com.example.hoangtin_ktgk.repository.NhanVienRepository;
import com.example.hoangtin_ktgk.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<NhanVien> findAllNhanViens() {
        return nhanVienRepository.findAll();
    }

    public NhanVien findNhanVienById(String id) {
        return nhanVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid NhanVien Id: " + id));
    }

    public NhanVien saveNhanVien(NhanVien nhanVien, String phongBanId) {
        PhongBan phongBan = phongBanRepository.findById(phongBanId).orElseThrow(() -> new IllegalArgumentException("Invalid PhongBan Id: " + phongBanId));
        nhanVien.setPhongBan(phongBan);
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid NhanVien Id: " + id));
        nhanVienRepository.delete(nhanVien);
    }

    public List<PhongBan> findAllPhongBans() {
        return phongBanRepository.findAll();
    }
}