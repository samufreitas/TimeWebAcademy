package Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao;

import java.util.List;

public interface IDao<T> {
    List<T> get();

    T get(Long id);

    List<T> get(String termoBusca);

    int insert(T objeto);

    int update(T objeto);

    int delete(T objeto);
}
