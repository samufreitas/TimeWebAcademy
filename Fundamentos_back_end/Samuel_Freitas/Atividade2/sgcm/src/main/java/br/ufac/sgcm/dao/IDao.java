package br.ufac.sgcm.dao;

import java.util.List;

public interface IDao<T> {
    //Definir os métodos que serão implementados nas classe Dao 
    List<T> get();

    T get(Long id);
    
    List<T> get(String termoBusca);

    int insert(T objeto);

    int update(T objeto);
    
    int delete(T objeto);
}
