package com.investree.sandboxing.view.impl;

import com.investree.sandboxing.model.Transaksi;
import com.investree.sandboxing.repository.TransaksiRepository;
import com.investree.sandboxing.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TransaksiPaymentImple implements TransaksiService {
    @Autowired
    public TransaksiRepository transaksiRepository;
    @Override
    public Map save(Transaksi obj) {
        Map map = new HashMap();
        try {
            Transaksi save = transaksiRepository.save(obj);
            map.put("data", save);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi obj) {
        Map map = new HashMap();
        try {
            Transaksi update = transaksiRepository.getById(obj.getId());
            update.setStatus(obj.getStatus());
            Transaksi doSave = transaksiRepository.save(update);
            map.put("data",doSave);
            map.put("code", "200");
            map.put("status", "success");
        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
        return map;
    }
}
