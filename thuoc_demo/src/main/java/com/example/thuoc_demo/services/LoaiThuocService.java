package com.example.thuoc_demo.services;

import com.example.thuoc_demo.models.LoaiThuoc;

import java.util.List;
import java.util.Optional;

public interface LoaiThuocService {
    List<LoaiThuoc> getAllLoaiThuoc();

    boolean insert(LoaiThuoc loaiThuoc);

    Optional<LoaiThuoc> getLoaiThuocById(long maLoai);
}
