package com.PinAppDef.PinAppChallenge.Clientes;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(schema = "cliente" )
public class Cliente {

    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private Integer edad;
    @Getter @Setter
    private LocalDate fechaNacimiento;
    @Getter @Setter
    private LocalDate fechaMuerte;


    public Cliente(long id, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaMuerte) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
    }

    public Cliente() {}

    public Cliente(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.edad = cliente.getEdad();
        this.fechaNacimiento = cliente.getFechaNacimiento();
        this.fechaMuerte = cliente.getFechaMuerte();
    }

    public void setFechaMuerte(LocalDate fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }



    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", Fecha_de_nacimiento=" + fechaNacimiento +
                '}';
    }

/**/
}
