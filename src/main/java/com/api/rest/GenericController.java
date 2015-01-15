package com.api.rest;

import com.api.dto.GenericDTO;
import com.api.entity.GenericEntity;
import com.api.mapper.GenericMapper;
import com.api.repository.GenericDaoJpa;
import com.api.service.GenericService;

public abstract class GenericController <E extends GenericEntity, T extends GenericDTO, A extends GenericDaoJpa<E, Integer>, M extends GenericMapper<T, E>, S extends GenericService> {
    /**
     * DaoJPA Repository
     */
    protected A daoJpa;

    /**
     * Mapper
     */
    protected M mapper;

    /**
     * Service
     */
    protected S service;
}
