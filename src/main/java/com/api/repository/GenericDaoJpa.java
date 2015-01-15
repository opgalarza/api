package com.api.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
@Transactional(readOnly = true)
public interface GenericDaoJpa<T, ID extends Serializable> extends CrudRepository<T, ID> {


	@QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	Iterable<T> findAll();

	@QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	List<T> findAll(Sort sort);

	@QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	Page<T> findAll(Pageable pageable);
	
	@QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	List<T> findAll(Specification<?> specification);

}
