/*
 * @ (#) AddressServicesImpl.java       1.0     11/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 11/11/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Address;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.AddressServices;

@Service
public class AddressServicesImpl implements AddressServices {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }


}
