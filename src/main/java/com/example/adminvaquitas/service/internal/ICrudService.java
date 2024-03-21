package com.example.adminvaquitas.service.internal;


import com.example.adminvaquitas.exceptions.HttpException;
import com.example.adminvaquitas.models.AuditModel;

import java.util.List;

public interface ICrudService<T extends AuditModel>{
    /**
     * Retrieves all elements from the service.
     *
     * @return List of elements.
     */
    List<T> getAll();

    long count();

    /**
     * Retrieves an element by its unique identifier.
     *
     * @param id Unique identifier of the element.
     * @return Found element.
     * @throws HttpException Thrown if the element is not found.
     */
    T getOne(String id) throws HttpException;

    /**
     * Saves a new element to the service.
     *
     * @param element Element to be saved.
     * @return Saved element.
     * @throws HttpException Thrown if an error occurs during the saving process.
     */
    T save(T element) throws HttpException;

    /**
     * Updates an existing element in the service.
     *
     * @param element Element with the updates.
     * @return Updated element.
     * @throws HttpException Thrown if the element to update is not found.
     */
    T update(String id, T element) throws HttpException;

    /**
     * Deletes an element from the service by its unique identifier.
     *
     * @param id Unique identifier of the element to be deleted.
     * @return Deleted element.
     * @throws HttpException Thrown if the element to delete is not found.
     */
    T delete(String id) throws HttpException;

    List<T> saveAll(List<T> elements) throws HttpException;
}
