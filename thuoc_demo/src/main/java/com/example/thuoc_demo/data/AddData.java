package com.example.thuoc_demo.data;

import com.example.thuoc_demo.models.LoaiThuoc;
import com.example.thuoc_demo.models.Thuoc;
import com.example.thuoc_demo.repositories.LoaiThuocRepository;

import java.time.LocalDate;
import java.util.List;

public class AddData {
    public static void main(String[] args){
        LoaiThuoc l1 = new LoaiThuoc("Thuoc Cam", null);
        Thuoc t1 = new Thuoc("Panadol", 5000, LocalDate.of(2024,1,1), l1);
        Thuoc t2 = new Thuoc("Aspirin", 3000, LocalDate.of(2023,2,1), l1);
        Thuoc t3 = new Thuoc("Ibuprofen", 8000, LocalDate.of(2022,10,1), l1);

        List<Thuoc> thuocs = List.of(t1, t2, t3);
        l1.setThuocs(thuocs);
        LoaiThuocRepository loaiThuocRepository = new LoaiThuocRepository();
        loaiThuocRepository.insert(l1);
    }
}
