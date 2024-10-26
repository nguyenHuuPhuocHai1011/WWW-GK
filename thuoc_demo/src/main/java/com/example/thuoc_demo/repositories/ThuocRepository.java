package com.example.thuoc_demo.repositories;

import com.example.thuoc_demo.models.LoaiThuoc;
import com.example.thuoc_demo.models.Thuoc;
import com.example.thuoc_demo.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class ThuocRepository extends CRUDRepository<Thuoc> {
    public ThuocRepository(){
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }

    public List<Thuoc> getThuocByLoai(long maLoai){
        List<Thuoc> thuocs = new ArrayList<>();
        try{
            transaction.begin();
            Query query = entityManager.createNamedQuery("thuoc.getThuocByLoai")
                    .setParameter("maLoai", LoaiThuoc.class);
            thuocs = query.getResultList();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return thuocs;
    }
}
