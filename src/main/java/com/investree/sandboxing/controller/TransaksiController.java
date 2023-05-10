package com.investree.sandboxing.controller;

import com.investree.sandboxing.model.Transaksi;
import com.investree.sandboxing.repository.TransaksiRepository;
import com.investree.sandboxing.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    public TransaksiService transaksiService;
    @Autowired
    public TransaksiRepository transaksiRepository;

    // done
    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Transaksi objModel) {
        Map save = transaksiService.save(objModel);
        return new ResponseEntity<Map>(save, HttpStatus.OK);
    }

    // done
    @PutMapping("")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel) {
        Map update = transaksiService.updateStatus(objModel);
        return new ResponseEntity<Map>(update, HttpStatus.OK);
    }

    // done
    @GetMapping("/list")
    public ResponseEntity<Map> list(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam(required = false) String status
    ) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> list = null;
        if (status != null) list = transaksiRepository.getByStatus(status, show_data);
        else list = transaksiRepository.getAllData(show_data);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data",list);
        map.put("code","200");
        map.put("status","success");

        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }
}
