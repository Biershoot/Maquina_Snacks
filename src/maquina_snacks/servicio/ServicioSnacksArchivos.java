package maquina_snacks.servicio;

import maquina_snacks.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class ServicioSnacksArchivos implements ServicioSnacks {
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();

    public ServicioSnacksArchivos() {
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe) {
                this.snacks = obtenerSnacks();
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Archivo creado");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
        if (!existe) {
            cargarSnacksIniciales();
        }
    }

    private void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Papas", 10.0));
        this.agregarSnack(new Snack("Refresco", 12.0));
        this.agregarSnack(new Snack("Chocolate", 8.0));
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea : lineas) {
                String[] datos = linea.split(",");
                var nombre = datos[0];
                var precio = Double.parseDouble(datos[1]);
                snacks.add(new Snack(nombre, precio));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener snacks: " + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        this.snacks.add(snack);
        agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack);
            salida.close();
        } catch (Exception e) {
            System.out.println("Error al agregar snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("---Snacks en el Inventario---");
        //Mostramos la lista de snakcs
        var inventarioSnacks = "";
        for (var snack: this.snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);

    }

    @Override
    public List<Snack> getSnacks() {
        return new ArrayList<>(snacks);
    }
}
