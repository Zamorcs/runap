package com.bindot.runap.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Calendario.class)
public abstract class Calendario_ {

	public static volatile SingularAttribute<Calendario, EstadoCalendario> estadoCalendario;
	public static volatile SingularAttribute<Calendario, Corredor> corredor;
	public static volatile ListAttribute<Calendario, CarreraGuardada> listaCarrerasGuardadas;
	public static volatile SingularAttribute<Calendario, Long> id;
	public static volatile SingularAttribute<Calendario, Boolean> enabled;

}

