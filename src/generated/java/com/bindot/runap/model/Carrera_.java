package com.bindot.runap.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Carrera.class)
public abstract class Carrera_ {

	public static volatile SingularAttribute<Carrera, String> descripcion;
	public static volatile ListAttribute<Carrera, Precio> listaPrecios;
	public static volatile ListAttribute<Carrera, Direccion> listaDirecciones;
	public static volatile SingularAttribute<Carrera, Formato> formato;
	public static volatile SingularAttribute<Carrera, Imagen> imagen;
	public static volatile ListAttribute<Carrera, RecKit> listaRecKits;
	public static volatile SingularAttribute<Carrera, Recorrido> recorrido;
	public static volatile SingularAttribute<Carrera, String> nombre;
	public static volatile SingularAttribute<Carrera, LocalDateTime> fechaFin;
	public static volatile SingularAttribute<Carrera, Boolean> enabled;
	public static volatile SingularAttribute<Carrera, String> pais;
	public static volatile SingularAttribute<Carrera, TipoCarrera> tipoCarrera;
	public static volatile SingularAttribute<Carrera, String> novedades;
	public static volatile SingularAttribute<Carrera, LocalDateTime> fechaInicio;
	public static volatile ListAttribute<Carrera, Distancia> listaDistancias;
	public static volatile SingularAttribute<Carrera, LocalDateTime> fechaInicioInscripcion;
	public static volatile SingularAttribute<Carrera, Long> id;
	public static volatile SingularAttribute<Carrera, String> webpage;
	public static volatile SingularAttribute<Carrera, String> organizador;

}

