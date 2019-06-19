package com.bindot.runap.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Direccion.class)
public abstract class Direccion_ {

	public static volatile SingularAttribute<Direccion, TipoDireccion> tipoDireccion;
	public static volatile SingularAttribute<Direccion, Long> numero;
	public static volatile SingularAttribute<Direccion, String> codigoPostal;
	public static volatile SingularAttribute<Direccion, String> calle;
	public static volatile SingularAttribute<Direccion, String> notas;
	public static volatile SingularAttribute<Direccion, String> localidad;
	public static volatile SingularAttribute<Direccion, Long> id;
	public static volatile SingularAttribute<Direccion, String> provincia;
	public static volatile SingularAttribute<Direccion, Boolean> enabled;
	public static volatile SingularAttribute<Direccion, String> pais;

}

