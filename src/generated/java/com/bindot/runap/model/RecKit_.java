package com.bindot.runap.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RecKit.class)
public abstract class RecKit_ {

	public static volatile SingularAttribute<RecKit, String> descripcion;
	public static volatile SingularAttribute<RecKit, LocalDateTime> fechaInicio;
	public static volatile SingularAttribute<RecKit, Direccion> direccion;
	public static volatile SingularAttribute<RecKit, Long> id;
	public static volatile SingularAttribute<RecKit, LocalDateTime> fechaFin;
	public static volatile SingularAttribute<RecKit, Documentacion> documentacion;

}

