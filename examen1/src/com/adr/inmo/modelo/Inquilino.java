package com.adr.inmo.modelo;
// Generated 24-jul-2014 10:11:35 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Inquilino generated by hbm2java
 */
@Entity
@Table(name="Inquilino"
    ,catalog="teide2014"
)
public class Inquilino  implements java.io.Serializable {


     private Integer idInquilino;
     private String dni;
     private String nombre;
     private int edad;
     private Boolean trabaja;
     private Set<Inmueble> inmuebles = new HashSet<Inmueble>(0);

    public Inquilino() {
    }

	
    public Inquilino(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Inquilino(String dni, String nombre, int edad, Boolean trabaja, Set<Inmueble> inmuebles) {
       this.dni = dni;
       this.nombre = nombre;
       this.edad = edad;
       this.trabaja = trabaja;
       this.inmuebles = inmuebles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idInquilino", unique=true, nullable=false)
    public Integer getIdInquilino() {
        return this.idInquilino;
    }
    
    public void setIdInquilino(Integer idInquilino) {
        this.idInquilino = idInquilino;
    }

    
    @Column(name="dni", nullable=false, length=45)
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    @Column(name="trabaja")
    public Boolean getTrabaja() {
        return this.trabaja;
    }
    
    public void setTrabaja(Boolean trabaja) {
        this.trabaja = trabaja;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="inquilino")
    public Set<Inmueble> getInmuebles() {
        return this.inmuebles;
    }
    
    public void setInmuebles(Set<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }




}

