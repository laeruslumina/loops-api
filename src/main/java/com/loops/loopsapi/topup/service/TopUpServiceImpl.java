package com.loops.loopsapi.topup.service;

import com.loops.loopsapi.user.persistence.User;
import com.loops.loopsapi.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;

@Service
@Validated
@RequiredArgsConstructor
public class TopUpServiceImpl implements TopUpService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public String addBalance(Long id,TopUpDto topUpDto) {
        User original = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        original.setBalance(original.getBalance().add(topUpDto.getBalance()));
        userRepository.save(original);
        return "Top Up Success";
    }

    @Override
    public String decreaseBalance(Long id,TopUpDto topUpDto) {
        User original = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist"));
        if (original.getBalance().compareTo(topUpDto.getBalance()) >= 0){
            original.setBalance(original.getBalance().subtract(topUpDto.getBalance()));// amount tidak boleh kosong, amount tidak cukup, success transaksi
            userRepository.save(original);
            return "Success";
        }

        return "Balance not enough";
    }
}
