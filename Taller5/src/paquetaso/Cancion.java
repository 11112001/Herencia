package paquetaso;

/*
 ________________
< I use arch btw >
 ----------------
   \
    \
        .--.
       |o_o |
       |:_/ |
      //   \ \
     (|     | )
    /'\_   _/`\
    \___)=(___/
 */


public class Cancion {
    private String nombre;
    private String artista;
    private String album;
    private int duracion;

    public Cancion(String nombre, String artista, String album, int duracion) 
    {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
    }

    // Getters y setters
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getArtista() {return artista;}
    public void setArtista(String artista) {this.artista = artista;}
    public String getAlbum() {return album;}
    public void setAlbum(String album) {this.album = album;}
    public int getDuracion() {return duracion;}
    public void setDuracion(int duracion) {this.duracion = duracion;}

    public String toString() 
    {
        return "Cancion: " + nombre + ", Artista: " + artista + ", Álbum: " + album + ", Duración: " + duracion + "s";
    }
}
