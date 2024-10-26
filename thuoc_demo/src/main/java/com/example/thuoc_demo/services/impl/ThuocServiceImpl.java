package com.example.thuoc_demo.services.impl;

import com.example.thuoc_demo.models.Thuoc;
import com.example.thuoc_demo.repositories.ThuocRepository;
import com.example.thuoc_demo.services.ThuocService;

import java.util.List;
import java.util.Optional;

public class ThuocServiceImpl implements ThuocService {
    private final ThuocRepository repository;

    public ThuocServiceImpl(){
        repository = new ThuocRepository();
    }

    @Override
    public List<Thuoc> getAllThuoc() {
        return repository.getAll(Thuoc.class);
    }

    @Override
    public List<Thuoc> getThuocByLoai(long maLoai) {
        return repository.getThuocByLoai(maLoai);
    }

    @Override
    public boolean insert(Thuoc thuoc) {
        return repository.insert(thuoc);
    }

    @Override
    public Thuoc getThuocDetail(long maThuoc) throws Exception {
        Optional<Thuoc> thuoc =repository.get(Thuoc.class, maThuoc);
        if(thuoc.isEmpty())
            throw new Exception("Not found");
        return thuoc.get();
    }
}
