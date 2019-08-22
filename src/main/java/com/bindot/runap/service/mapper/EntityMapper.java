/**
 * 
 */
package com.bindot.runap.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.bindot.runap.model.ARunapEntity;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D>
 *            - DTO type parameter.
 * @param <E>
 *            - Entity type parameter.
 */
public interface EntityMapper<D, E> {

	E toEntity(D dto);

	D toDto(E entity);

	List<E> toEntity(List<D> dtoList);

	List<D> toDto(List<E> entityList);
	
	default Long entityToLong(E value) {
		return ((ARunapEntity)value).getId();
	};
	
	default List<Long> entityListToLongList(List<E> values){
		List<Long> list= new ArrayList<>();
		for (E entity : values) {
			list.add(((ARunapEntity)entity).getId());
		}
		return list;
	}

//	@SuppressWarnings("unchecked")
//	default E longToEntity(Long value, ARunapEntity object) {
//		object.setId(value);
//		return (E) object;
//	}
//	
//	@SuppressWarnings("unchecked")
//	default List<E> longListToEntityList(List<Long> values, ARunapEntity object){
//		Class<? extends ARunapEntity> modelClass = object.getClass();
//		ArrayList<ARunapEntity> objects = new ArrayList<ARunapEntity>();
//		for (Long value : values) {
//			try {
//				ARunapEntity instance = modelClass.newInstance();
//				instance.setId(value);
//				objects.add(instance);
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}
//		return (List<E>) objects;
//	}

}
