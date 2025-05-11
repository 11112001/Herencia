package paquetaso;

import java.util.ArrayList;

public class Premium extends Usuario {
    private int puntos;
    private ArrayList<Cancion> cancionesDescargadas;

    public Premium(String nombre, String contrasena) 
    {
        super(nombre, contrasena);
        this.puntos = 0;
        this.cancionesDescargadas = new ArrayList<>();
    }

    // Getters y setters
    public int getPuntos() {return puntos;}
    public void setPuntos(int puntos) {this.puntos = puntos;}
    public ArrayList<Cancion> getCancionesDescargadas() {return cancionesDescargadas;}
    public void setCancionesDescargadas(ArrayList<Cancion> cancionesDescargadas) {this.cancionesDescargadas = cancionesDescargadas;}

    public void reproducirCancion(Cancion cancion) 
    {
        super.reproducirCancion(cancion);
        puntos += 2; 
    }

    public void verPuntuacion() 
    {
        System.out.println("Usted tiene un total de " + puntos + " puntos.");
    }

    public void mostrarCancionesDescargadas() 
    {
        imprimirLista(cancionesDescargadas);
    }

    public void descargarCancion(Cancion cancion) 
    {
        cancionesDescargadas.add(cancion);
    }
}
