package com.bindot.runap.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Precio.class)
public abstract class Precio_ {

	public static volatile SingularAttribute<Precio, String> descripcion;
	public static volatile SingularAttribute<Precio, Long> monto;
	public static volatile SingularAttribute<Precio, LocalDateTime> fechaInicio;
	public static volatile SingularAttribute<Precio, String> moneda;
	public static volatile SingularAttribute<Precio, Long> id;
	public static volatile SingularAttribute<Precio, LocalDateTime> fechaFin;
	public static volatile SingularAttribute<Precio, Boolean> enabled;

}

