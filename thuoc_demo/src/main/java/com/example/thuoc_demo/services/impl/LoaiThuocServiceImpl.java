package com.example.thuoc_demo.services.impl;

import com.example.thuoc_demo.models.LoaiThuoc;
import com.example.thuoc_demo.repositories.LoaiThuocRepository;
import com.example.thuoc_demo.services.LoaiThuocService;

import java.util.List;
import java.util.Optional;

public class LoaiThuocServiceImpl implements LoaiThuocService {
    private final LoaiThuocRepository repository;

    public LoaiThuocServiceImpl(){
        repository = new LoaiThuocRepository();
    }


    @Override
    public List<LoaiThuoc> getAllLoaiThuoc() {
        return repository.getAll(LoaiThuoc.class);
    }

    @Override
    public boolean insert(LoaiThuoc loaiThuoc) {
        return repository.insert(loaiThuoc);
    }

    @Override
    public Optional<LoaiThuoc> getLoaiThuocById(long maLoai) {
        return repository.get(LoaiThuoc.class, maLoai);
    }
}
