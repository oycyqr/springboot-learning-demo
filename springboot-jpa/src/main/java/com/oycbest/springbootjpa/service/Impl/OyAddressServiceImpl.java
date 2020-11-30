package com.oycbest.springbootjpa.service.Impl;

import com.oycbest.springbootjpa.dao.OyAddressRepository;
import com.oycbest.springbootjpa.entity.OyAddress;
import com.oycbest.springbootjpa.service.OyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName OyAddressServiceImpl
 * @Description TODO
 * @Author oyc
 * @Date 2020/11/30 14:34
 * @Version
 */
@Service
public class OyAddressServiceImpl implements OyAddressService<OyAddress> {

    @Autowired
    private OyAddressRepository addressRepository;

    @Override
    public List list() {
        return addressRepository.findAll();
    }


    @Override
    @Transactional
    public void save(OyAddress address) {
        addressRepository.save(address);
    }

    @Override
//    @Transactional
    public void save(List<OyAddress> addresses) {
        addresses.forEach(s->addressRepository.save(s));
    }


    @Override
    public Page<OyAddress> pageList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OyAddress> pageList = addressRepository.findAll(pageable);
        return pageList;
    }


}