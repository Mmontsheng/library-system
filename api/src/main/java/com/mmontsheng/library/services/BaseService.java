package com.mmontsheng.library.services;

import java.util.List;

/**
 * 
 * @author Mmontsheng
 *
 */
public interface BaseService<T, S> {
    /**
     * 
     * @return
     */
    List<T> get();

    /**
     * 
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 
     * @param enabled
     * @return
     */
    List<T> get(Boolean enabled);
    
    /**
     * 
     * @param request
     * @return
     */
    T create(S request);

    /**
     * 
     * @param id
     * @param request
     * @return
     */
    T update(String id, S request);

    /**
     * 
     * @param id
     */
    void delete(String id);

    /**
     * 
     * @param id
     */
    T toggleStatus(String id);
    
    /**
     * 
     * @param entity
     * @return
     */
    T save(T entity);
}
