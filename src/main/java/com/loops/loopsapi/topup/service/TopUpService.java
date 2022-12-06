package com.loops.loopsapi.topup.service;

public interface TopUpService {

    String addBalance (Long id,TopUpDto topUpDto);

    String decreaseBalance (Long id, TopUpDto topUpDto);

}
