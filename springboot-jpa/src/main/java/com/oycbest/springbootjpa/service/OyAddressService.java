package com.oycbest.springbootjpa.service;

import com.oycbest.springbootjpa.entity.OyAddress;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author admin
 */
public interface OyAddressService<T extends OyAddress> {

    List<T> list();

    Page<T> pageList(int page, int size);

    void save(T address);

    void save(List<T> addresses);

}
