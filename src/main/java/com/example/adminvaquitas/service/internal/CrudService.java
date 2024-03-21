package com.example.adminvaquitas.service.internal;

import com.example.adminvaquitas.exceptions.HttpException;
import com.example.adminvaquitas.models.AuditModel;
import com.example.adminvaquitas.repositories.AuditRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class CrudService<T extends AuditModel> implements ICrudService<T>{
    private final AuditRepository<T> repository;

    /**
     * Crea una nueva instancia de CrudService.
     *
     * @param repository El repositorio de datos para el modelo T.
     */
    public CrudService(AuditRepository<T> repository) {
        this.repository = repository;
    }

    /**
     * Obtiene una lista de todos los elementos del modelo T.
     *
     * @return Una lista de elementos del modelo T.
     */
    @Override
    public List<T> getAll() {
        return (List<T>) this.repository.findAll();
    }

    /**
     * Obtiene el número total de elementos del modelo T.
     *
     * @return El número de elementos del modelo T.
     */
    @Override
    public long count() {
        return this.repository.count();
    }

    /**
     * Obtiene un elemento del modelo T por su ID.
     *
     * @param id El ID del elemento a buscar.
     * @return El elemento del modelo T encontrado.
     * @throws HttpException Si no se proporciona un ID o si no se encuentra el elemento.
     */
    @Override
    public T getOne(String id) throws HttpException {
        return findElement(id);
    }

    /**
     * Guarda un nuevo elemento del modelo T.
     *
     * @param element El elemento a guardar.
     * @return El elemento guardado.
     * @throws HttpException Si ocurre un error al guardar el elemento.
     */
    @Override
    public T save(T element) throws HttpException {
        return this.repository.save(element);
    }

    /**
     * Actualiza un elemento existente del modelo T.
     *
     * @param id      El ID del elemento a actualizar.
     * @param element El elemento actualizado.
     * @return El elemento actualizado.
     * @throws HttpException Si no se encuentra el elemento a actualizar.
     */
    @Override
    public T update(String id, T element) throws HttpException {
        this.findElement(id);
        element.setId(id);
        this.repository.save(element);
        return element;
    }

    /**
     * Elimina un elemento del modelo T por su ID.
     *
     * @param id El ID del elemento a eliminar.
     * @return El elemento eliminado.
     * @throws HttpException Si no se encuentra el elemento a eliminar.
     */
    @Override
    public T delete(String id) throws HttpException {
        T foundElement = this.findElement(id);
        this.repository.deleteById(id);
        return foundElement;
    }

    /**
     * Guarda una lista de elementos del modelo T.
     *
     * @param elements La lista de elementos a guardar.
     * @return La lista de elementos guardados.
     * @throws HttpException Si ocurre un error al guardar los elementos.
     */
    @Override
    public List<T> saveAll(List<T> elements) throws HttpException {
        return this.repository.saveAll(elements);
    }

    /**
     * Busca un elemento del modelo T por su ID.
     *
     * @param id El ID del elemento a buscar.
     * @return El elemento encontrado.
     * @throws HttpException Si no se proporciona un ID o si no se encuentra el elemento.
     */
    private T findElement(String id) throws HttpException {
        if (id == null) throw new HttpException("No id provided", HttpStatus.BAD_REQUEST);
        Optional<T> foundElement = this.repository.findById(id);
        if (foundElement.isEmpty()) {
            throw new HttpException("Not found", HttpStatus.NOT_FOUND);
        }
        return foundElement.get();
    }

}
