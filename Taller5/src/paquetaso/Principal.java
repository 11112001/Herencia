package paquetaso;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Spotify spotify = new Spotify();

        // Agregar canciones al Spotify
        spotify.agregarCancion(new Cancion("Kiss me now", "Pierce the Veil", "The Jaws of life (Deluxe)", 416));
        spotify.agregarCancion(new Cancion("Borderline", "Tame Impala", "Borderline", 358));
        spotify.agregarCancion(new Cancion("Mojabi Ghost", "Tainy, BadBunny", "Data", 352));
        spotify.agregarCancion(new Cancion("Que locura enamorarme de ti", "Eddie Santiago", "De verdad (deluxe)", 510));
        spotify.agregarCancion(new Cancion("Her Distortion", "Xójira", "Me & other personalities", 315));
        spotify.agregarCancion(new Cancion("No one like you", "Scorpions", "Blackout", 357));
        spotify.agregarCancion(new Cancion("I belong to you", "Muse", "The Resistance", 539));
        spotify.agregarCancion(new Cancion("Nuestro Destino", "Julio Jaramillo", "Ayer Y hoy (remastered)", 228));
        spotify.agregarCancion(new Cancion("With or Without you", "U2", "U218 Singles", 456));
        spotify.agregarCancion(new Cancion("Interlude", "My Chemical Romance", "Three Cheers For Sweet Revenge", 57));

        // Menú 
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("\n----- Menú de Opciones -----");
            System.out.println("1. Registrarse");
            System.out.println("2. Ver canciones disponibles");
            System.out.println("3. Añadir canción a 'Me gusta'");
            System.out.println("4. Reproducir playlist de 'Me gusta'");
            System.out.println("5. Descargar canción (solo Premium)");
            System.out.println("6. Ver canciones descargadas (solo Premium)");
            System.out.println("7. Ver puntos (solo Premium)");
            System.out.println("8. Mostrar canciones de MG");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        // Registro de usuario
                        System.out.print("Ingrese nombre de usuario: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        String contrasena = scanner.nextLine();
                        System.out.print("¿Es usuario Premium? (true/false): ");
                        boolean premium = Boolean.parseBoolean(scanner.nextLine());
                        spotify.registrarUsuario(nombre, contrasena, premium);
                        System.out.println("Usuario registrado correctamente.");
                        break;
                    case 2:
                        // Ver canciones disponibles
                        System.out.println("Canciones disponibles en Spotify:");
                        spotify.mostrarCanciones();
                        break;
                    case 3:
                        // Añadir canción a 'Me gusta'
                        System.out.print("Ingrese nombre de usuario: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        contrasena = scanner.nextLine();
                        Usuario usuario = spotify.buscarUsuario(nombre, contrasena);
                        if (usuario != null) {
                            System.out.print("Ingrese el nombre de la canción a añadir a 'Me gusta': ");
                            String cancionNombre = scanner.nextLine();
                            Cancion cancion = spotify.seleccionarCancion(cancionNombre);
                            if (cancion != null) {
                                usuario.like(cancion);
                                System.out.println("Canción añadida a 'Me gusta'.");
                            } else {
                                System.out.println("Canción no encontrada.");
                            }
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    case 4:
                        // Reproducir playlist de 'Me gusta'
                        System.out.print("Ingrese nombre de usuario: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        contrasena = scanner.nextLine();
                        usuario = spotify.buscarUsuario(nombre, contrasena);
                        if (usuario != null) {
                            System.out.println("Reproduciendo playlist de 'Me gusta'...");
                            usuario.reproducirPlayList(usuario.getMeGusta());
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    case 5:
                        // Descargar canción (solo Premium)
                        System.out.print("Ingrese nombre de usuario: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        contrasena = scanner.nextLine();
                        Usuario usuarioPremium = spotify.buscarUsuario(nombre, contrasena);
                        if (usuarioPremium != null && usuarioPremium instanceof Premium) {
                            System.out.print("Ingrese el nombre de la canción a descargar: ");
                            String cancionDescargar = scanner.nextLine();
                            Cancion cancion = spotify.seleccionarCancion(cancionDescargar);
                            if (cancion != null) {
                                ((Premium) usuarioPremium).descargarCancion(cancion);
                                System.out.println("Canción descargada.");
                            } else {
                                System.out.println("Canción no encontrada.");
                            }
                        } else {
                            System.out.println("Usuario no encontrado o no es Premium.");
                        }
                        break;
                    case 6:
                        // Ver canciones descargadas (solo Premium)
                        System.out.print("Ingrese nombre de usuario: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        contrasena = scanner.nextLine();
                        usuarioPremium = spotify.buscarUsuario(nombre, contrasena);
                        if (usuarioPremium != null && usuarioPremium instanceof Premium) {
                            System.out.println("Canciones descargadas:");
                            ((Premium) usuarioPremium).mostrarCancionesDescargadas();
                        } else {
                            System.out.println("Usuario no encontrado o no es Premium.");
                        }
                        break;
                    case 7:
                        // Ver puntos (solo Premium)
                        System.out.print("Ingrese nombre de usuario: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        contrasena = scanner.nextLine();
                        usuarioPremium = spotify.buscarUsuario(nombre, contrasena);
                        if (usuarioPremium != null && usuarioPremium instanceof Premium) {
                            ((Premium) usuarioPremium).verPuntuacion();
                        } else {
                            System.out.println("Usuario no encontrado o no es Premium.");
                        }
                        break;
                    case 8:
                        // Buscar y agregar canción a 'Me gusta'
                        System.out.print("Ingrese nombre de usuario: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        contrasena = scanner.nextLine();
                        usuario = spotify.buscarUsuario(nombre, contrasena);
                        if (usuario != null) {
                            boolean Orden = true;
                            System.out.print("Canciones ordenadas: ");
                            usuario.verMeGusta(Orden);
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    case 9:
                        // Salir
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
