package br.cesjf.hotellucena.model;

import br.cesjf.hotellucena.model.Apartamento;
import br.cesjf.hotellucena.model.Itens;
import br.cesjf.hotellucena.model.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-20T15:46:42")
@StaticMetamodel(Reservas.class)
public class Reservas_ { 

    public static volatile SingularAttribute<Reservas, Integer> codigoReserva;
    public static volatile ListAttribute<Reservas, Itens> itensList;
    public static volatile SingularAttribute<Reservas, Integer> numeroHospedes;
    public static volatile SingularAttribute<Reservas, Date> dataEntrada;
    public static volatile SingularAttribute<Reservas, Usuarios> usuarioscodUsuario;
    public static volatile SingularAttribute<Reservas, Double> valorPago;
    public static volatile SingularAttribute<Reservas, Date> dataSaida;
    public static volatile SingularAttribute<Reservas, Apartamento> apartamentocodigoApartamento;
    public static volatile SingularAttribute<Reservas, String> status;

}