package com.bindot.runap.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Corredor.class)
public abstract class Corredor_ {

	public static volatile SingularAttribute<Corredor, LocalDateTime> fechaNacimiento;
	public static volatile SingularAttribute<Corredor, String> social;
	public static volatile SingularAttribute<Corredor, LocalDateTime> fechaUltimoLogin;
	public static volatile SingularAttribute<Corredor, LocalDateTime> fechaRegistro;
	public static volatile SingularAttribute<Corredor, Long> friendlist;
	public static volatile SingularAttribute<Corredor, Avatar> avatar;
	public static volatile SingularAttribute<Corredor, String> nombre;
	public static volatile SingularAttribute<Corredor, Boolean> enabled;
	public static volatile SingularAttribute<Corredor, String> apellido;
	public static volatile SingularAttribute<Corredor, TipoCorredor> tipoCorredor;
	public static volatile SingularAttribute<Corredor, Long> id;
	public static volatile SingularAttribute<Corredor, Long> runningTeam;
	public static volatile SingularAttribute<Corredor, Sexo> sexo;
	public static volatile SingularAttribute<Corredor, String> email;

}

