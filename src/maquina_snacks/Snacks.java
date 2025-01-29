package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private  static final List<Snack> snacks;


    //Bloque static para inicializar la lista de snacks
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70.0));
        snacks.add(new Snack("Refresco", 50.0));
        snacks.add(new Snack("Chocolate", 120.0));
        snacks.add(new Snack("Galletas", 8.0));
    }
    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }
    public static  void  mostrarSnacks(){
        var inventarioSnacks ="";
        for (var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("---Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }
    public static List<Snack> getSnacks() {
        return snacks;
    }
}
