
package modelo;

import java.time.LocalDate;

public class Cliente {

    private int numero;
    private String nombre;
    private float puntos;
    private LocalDate fechaNacimiento;

    public Cliente(
            int numero,
            String nombre,
            float puntos,
            LocalDate fechaNacimiento) {

        setNumero(numero);
        setNombre(nombre);
        setPuntos(puntos);
        setFechaNacimiento(fechaNacimiento);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException(
                    "El número debe ser positivo");
        }
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "Debes introducir un nombre");
        }
        this.nombre = nombre;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        if (Float.isNaN(puntos)
                || Float.isInfinite(puntos)
                || puntos < 0 || puntos > 1000) {

            throw new IllegalArgumentException(
                    "Los puntos deben estar entre 0 y 1000");
        }
        this.puntos = puntos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException(
                    "Debes introducir una fecha");
        }

        if (fechaNacimiento.getYear() < 1900
                || fechaNacimiento.getYear() > 2015) {

            throw new IllegalArgumentException(
                    "El año debe estar entre 1900 y 2015");
        }

        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente: "
                + "Número = " + numero
                + ", Nombre = " + nombre
                + ", Puntos = " + puntos
                + ", Fecha de nacimiento = " + fechaNacimiento;
    }
}
