package com.example.thuoc_demo.services;

import com.example.thuoc_demo.models.Thuoc;

import java.util.List;

public interface ThuocService {
    List<Thuoc> getAllThuoc();
    List<Thuoc> getThuocByLoai(long maLoai);
    boolean insert(Thuoc thuoc);
    Thuoc getThuocDetail(long maThuoc) throws Exception;
}
