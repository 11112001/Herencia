package paquetaso;

import java.util.ArrayList;

public class Freemium extends Usuario 
{
    private int cancionesSinPublicidad;

    public Freemium(String nombre, String contrasena) 
    {
        super(nombre, contrasena);
        this.cancionesSinPublicidad = 0;
    }

    public void mostrarPublicidad() 
    {
        System.out.println("¿Cansado de los anuncios? Pues nosotros también");
    }

    public void reproducirPlayList(ArrayList<Cancion> playlist) 
    {
        for (int i = 0; i < playlist.size(); i++) 
        {
            if (cancionesSinPublicidad == 3) 
            {
                mostrarPublicidad();
                cancionesSinPublicidad = 0;
            }
            super.reproducirCancion(playlist.get(i));
            cancionesSinPublicidad++;
        }
    }
}

