package com.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.dto.GenericDTO;
import com.api.dto.PageDTO;
import com.api.entity.GenericEntity;
import com.api.exception.CreateEntityException;
import com.api.exception.NonExistentEntityException;
import com.api.mapper.GenericMapper;
import com.api.repository.GenericDaoJpa;



@Transactional(readOnly = true)
public abstract class GenericService<E extends GenericEntity, T extends GenericDTO, A extends GenericDaoJpa<E, Integer>, M extends GenericMapper<T, E>> {

    /**
     * Repository
     */
    protected A daoJpa;

    /**
     * Mapper
     */
    protected M mapper;

    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageDTO<T> getEntityList(Integer pageNumber, Integer pageSize, String bindMode) {
        Page<E> page = daoJpa.findAll(new PageRequest(pageNumber, pageSize, new Sort(new Sort.Order(Sort.Direction.ASC, "id"))));
        return new PageDTO<T>(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements(), mapper.bindDTOList(page, bindMode));
    }

    /**
     * GET
     * <p/>
     *
     * @param id
     * @return
     */
    public T getEntity(@PathVariable("id") Integer id, String bindMode) throws NonExistentEntityException {
        E entity = daoJpa.findOne(id);
        if (null == entity) {
            throw new NonExistentEntityException("Entity with id '" + id + "' is not found.");
        }
        return mapper.bindDTO(entity, bindMode);
    }

    /**
     * PUT
     * <p/>
     *
     * @param id
     * @param dto
     * @return
     * @throws NonExistentEntityException 
     */
    @Transactional
    public T putEntity(@PathVariable("id") Integer id, @RequestBody T dto) throws NonExistentEntityException{
        E entity = daoJpa.findOne(id);
        if (null == entity) {
            throw new NonExistentEntityException("Entity with id '" + id + "' is not found.");
        }
        try {
            entity = daoJpa.save(mapper.updateEntity(dto, entity));
            return mapper.bindDTO(entity);
        } catch (Exception e) {
            throw new NonExistentEntityException(e.getMessage(), e);
        }
    }

    /**
     * POST
     * <p/>
     *
     * @param dto
     * @return
     * @throws CreateEntityException 
     * @throws BaseAtlasException
     */
    @Transactional
    public T postEntity(@RequestBody T dto) throws CreateEntityException {
        dto.setDefaultFields();
        E entity;
        try {
            entity = daoJpa.save(mapper.updateEntity(dto, getEntityInstance()));
            return mapper.bindDTO(entity);
        } catch (Exception e) {
            throw new CreateEntityException(e.getMessage(), e);
        }
    }

    /**
     * DELETE
     * <p/>
     *
     * @param id
     * @throws NonExistentEntityException 
     * @throws BaseAtlasException
     */
    @Transactional
    public void deleteEntity(@PathVariable("id") Integer id) throws NonExistentEntityException {
        E entity = daoJpa.findOne(id);
        if (null == entity) {
            throw new NonExistentEntityException("Entity with id '" + id + "' is not found.");
        }
        daoJpa.delete(entity);
    }

    private String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    /**
     * @return
     */
    protected abstract E getEntityInstance();
}
