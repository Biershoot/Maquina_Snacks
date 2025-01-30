package maquina_snacks.servicio;

import maquina_snacks.dominio.Snack;

import java.util.List;

public interface ServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List<Snack> getSnacks();

}
