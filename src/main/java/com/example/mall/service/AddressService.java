package com.example.mall.service;

import com.example.mall.entity.Address;
import com.example.mall.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;


    public List<Address> getUserAddresses(int userId) {
        return addressMapper.findByUserId(userId);
    }

    public void addAddress(Address address) {
        addressMapper.insert(address);
    }

    public Address getAddressById(int id) {
        return addressMapper.findById(id);
    }

    public void updateAddress(Address address) {
        addressMapper.update(address);
    }

    public void deleteAddress(int id) {
        addressMapper.delete(id);
    }
}
