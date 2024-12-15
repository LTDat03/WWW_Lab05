/*
 * @ (#) CustomUserDetailsServices.java       1.0     12/13/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/13/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.User;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.UserRepository;

import java.util.Collections;
import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs.UserDetails(user);
    }
}
