package paquetaso;

import java.util.ArrayList;

public class Spotify {
    private ArrayList<Cancion> canciones;
    private ArrayList<Premium> usuariosPremium;
    private ArrayList<Freemium> usuariosFreemium;

    public Spotify() 
    {
        canciones = new ArrayList<>();
        usuariosPremium = new ArrayList<>();
        usuariosFreemium = new ArrayList<>();
    }

    public void registrarUsuario(String nombre, String contrasena, boolean premium) 
    {
        if (premium) 
        {
            usuariosPremium.add(new Premium(nombre, contrasena));
        } else 
        {
            usuariosFreemium.add(new Freemium(nombre, contrasena));
        }
    }

    public Usuario buscarUsuario(String nombre, String contrasena) 
    {
        for (int i = 0; i < usuariosPremium.size(); i++) 
        {
            if (usuariosPremium.get(i).getNombre().equals(nombre) && usuariosPremium.get(i).getContrasena().equals(contrasena)) 
            {
                return usuariosPremium.get(i);
            }
        }
        for (int i = 0; i < usuariosFreemium.size(); i++) 
        {
            if (usuariosFreemium.get(i).getNombre().equals(nombre) && usuariosFreemium.get(i).getContrasena().equals(contrasena)) 
            {
                return usuariosFreemium.get(i);
            }
        }
        return null;
    }

    public void mostrarCanciones() 
    {
        for (int i = 0; i < canciones.size(); i++) 
        {
            System.out.println(canciones.get(i));
        }
    }

    public Cancion seleccionarCancion(String nombre) 
    {
        for (int i = 0; i < canciones.size(); i++) 
        {
            if (canciones.get(i).getNombre().equals(nombre)) 
            {
                return canciones.get(i);
            }
        }
        return null;
    }

    public void agregarCancion(Cancion cancion) 
    {
        canciones.add(cancion);
    }
}
