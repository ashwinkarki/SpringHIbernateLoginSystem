/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acem.sp.dao;

import java.util.List;

/**
 *
 * @author AshwinKArki
 */
public interface GenericDAO<T> {
    List<T> getAll();
    T getById(int id);
    void insert(T t);
    void update(T t);
    void delete(int id);
}
