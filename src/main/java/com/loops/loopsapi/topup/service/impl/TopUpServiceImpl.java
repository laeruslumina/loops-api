package com.loops.loopsapi.topup.service.impl;

import com.loops.loopsapi.topup.service.TopUpService;
import com.loops.loopsapi.user.persistence.User;
import com.loops.loopsapi.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
@Validated
@RequiredArgsConstructor
public class TopUpServiceImpl implements TopUpService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public void addBalance(Long id,BigDecimal input) {
        User original = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        original.setBalance(original.getBalance().add(input));
        userRepository.save(original);
    }

    @Override
    public void decreaseBalance(Long id, BigDecimal input){
        User original = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        if (original.getBalance().compareTo(input) >= 0){
            original.setBalance(original.getBalance().subtract(input));// amount tidak boleh kosong, amount tidak cukup, success transaksi
            userRepository.save(original);
        }else{
            throw new ServiceException("Not enough balance");
        }
    }
}
