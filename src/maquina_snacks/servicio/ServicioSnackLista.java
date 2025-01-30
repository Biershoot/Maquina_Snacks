package maquina_snacks.servicio;

import maquina_snacks.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnackLista implements ServicioSnacks {
    private final List<Snack> snacks;

    // Constructor to initialize the list of snacks
    public ServicioSnackLista() {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70.0));
        snacks.add(new Snack("Refresco", 50.0));
        snacks.add(new Snack("Chocolate", 120.0));
        snacks.add(new Snack("Galletas", 8.0));
    }

    @Override
    public void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public  void mostrarSnacks() {
        var inventarioSnacks = "";
        for (var snack : snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("---Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return snacks;
    }
}