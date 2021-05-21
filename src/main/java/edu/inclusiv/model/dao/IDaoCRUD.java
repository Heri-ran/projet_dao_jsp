package edu.inclusiv.model.dao;

import java.util.List;

public interface IDaoCRUD<E> {
	public E save(E entity);
	public List<E> findAll();
	public E remove(E entity);
	public E update(E entity);
}
