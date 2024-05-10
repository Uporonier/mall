package com.example.mall.controller;

import com.example.mall.common.Result;
import com.example.mall.entity.Address;
import com.example.mall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/address")
    public class AddressController {

        @Autowired
        private AddressService addressService;

        @GetMapping("/getall/{userId}")
        public Result getUserAddresses(@PathVariable("userId") int userId) {
            List<Address> addresses = addressService.getUserAddresses(userId);
            return Result.success(addresses);
        }
    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
        return Result.success();
    }

    @GetMapping("/address/{id}")
        public Result getAddressById(@PathVariable("id") int id) {
        Address address = addressService.getAddressById(id);
        System.out.println(address);
        return Result.success(address);
    }

    @PutMapping("/updateAddress/{id}")
    public Result updateAddress(@PathVariable("id") int id, @RequestBody Address address) {
        address.setId(id);
        addressService.updateAddress(address);
        return Result.success();
    }

    @DeleteMapping("/deleteAddress/{id}")
    public Result deleteAddress(@PathVariable("id") int id) {
        addressService.deleteAddress(id);
        return Result.success();
    }
}
