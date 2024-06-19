package com.example.hoangtin_ktgk.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "PhongBan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong", length = 2, nullable = false)
    private String maPhong;

    @Column(name = "Ten_Phong", length = 30)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan")
    @ToString.Exclude
    private List<NhanVien> nhanViens;

    public PhongBan(String maPhong, String tenPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
    }
}
