package paquetaso;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Spotify spotify = new Spotify();

        spotify.agregarCancion(new Cancion("Song 1", "Artist 1", "Album 1", 180));
        spotify.agregarCancion(new Cancion("Song 2", "Artist 2", "Album 2", 200));
        
        // Crear usuarios Premium y Freemium
        spotify.registrarUsuario("premiumUser1", "password1", true);
        spotify.registrarUsuario("premiumUser2", "password2", true);
        spotify.registrarUsuario("freemiumUser1", "password3", false);
        spotify.registrarUsuario("freemiumUser2", "password4", false);

        // Simular el resto de las acciones descritas en el taller
        // ...
    }
}

