package paquetaso;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String contrasena;
    private ArrayList<Cancion> meGusta;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.meGusta = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getContrasena() {return contrasena;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
    public ArrayList<Cancion> getMeGusta() {return meGusta;}
    public void setMeGusta(ArrayList<Cancion> meGusta) {this.meGusta = meGusta;}

    // Métodos
    public void reproducirCancion(Cancion cancion) 
    {
        System.out.println("Reproduciendo: " + cancion);
    }

    public void reproducirPlayList(ArrayList<Cancion> playlist) 
    {
        for (int i = 0; i < playlist.size(); i++) {

            reproducirCancion(playlist.get(i));
            try 
            {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void imprimirLista(ArrayList<Cancion> lista) 
    {
        for (int i = 0; i < lista.size(); i++) 
        {
            System.out.println(lista.get(i));
        }
    }

    public void verMeGusta(boolean ordenAlfabetico) 
    {
        if (ordenAlfabetico) 
        {
            for (int i = 0; i < meGusta.size(); i++) 
            {
                for (int j = i + 1; j < meGusta.size(); j++) 
                {
                    if (meGusta.get(i).getNombre().compareTo(meGusta.get(j).getNombre()) > 0) 
                    {
                        Cancion temp = meGusta.get(i);
                        meGusta.set(i, meGusta.get(j));
                        meGusta.set(j, temp);
                    }
                }
            }
        }
        imprimirLista(meGusta);
    }

    public void like(Cancion cancion) 
    {
        meGusta.add(cancion);
    }

    public void dislike(Cancion cancion) 
    {
        meGusta.remove(cancion);
    }
}
