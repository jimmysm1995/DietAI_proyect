package com.backend.DietAIbackend.service;

import java.util.List;

public interface ICrudService<T, I> {

    List<T> findAll();
    T findById(I var1);
    void deleteById(I var1);
    T update(T var1);
}
