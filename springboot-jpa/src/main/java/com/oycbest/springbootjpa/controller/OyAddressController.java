package com.oycbest.springbootjpa.controller;

import com.oycbest.springbootjpa.entity.OyAddress;
import com.oycbest.springbootjpa.service.OyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OyAddressController
 * @Description 地址控制类
 * @Author oyc
 * @Date 2020/11/30 14:30
 * @Version
 */
@RestController
@RequestMapping("address")
public class OyAddressController {

    @Autowired
    private OyAddressService<OyAddress> addressService;

    @GetMapping
    public List<OyAddress> list() {
        return addressService.list();
    }

    @GetMapping("page")
    public Page<OyAddress> pageList(@RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "size", defaultValue = "10") int size) {
        return addressService.pageList(page - 1, size);
    }

    @PostMapping
    public void save(OyAddress address,int num) {
        List list = new ArrayList();
        String city = address.getCity();
        String detailAddress = address.getDetailAddress();
        for (int i = 0; i < num; i++) {
            OyAddress oyAddress = new OyAddress(city + "-" + i, detailAddress + "-" + i, new Date());
            if (i == 8) {
                oyAddress.setId(8);
            }
            list.add(oyAddress);
        }
        addressService.save(list);
    }
}