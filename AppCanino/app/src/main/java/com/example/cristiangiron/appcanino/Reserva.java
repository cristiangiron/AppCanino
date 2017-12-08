package com.example.cristiangiron.appcanino;

/**
 * Created by CristianGiron on 13/06/2017.
 */

public class Reserva {

    Long idreserva;
    String fecha;
    String hora;
    String nombre;



    public Reserva (String fecha, String hora, String nombre){
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
    }

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
