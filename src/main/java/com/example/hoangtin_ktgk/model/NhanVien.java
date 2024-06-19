package com.example.hoangtin_ktgk.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NhanVien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

    @Id
    @Column(name = "Ma_NV", length = 3, nullable = false)
    private String maNV;

    @Column(name = "Ten_NV", length = 100, nullable = false)
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "Ma_Phong", referencedColumnName = "Ma_Phong")
    private PhongBan phongBan;

    @Column(name = "Luong")
    private Integer luong;
}
