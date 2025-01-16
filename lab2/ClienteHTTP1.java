import java.net.*;
import java.io.*;
import java.util.*;

class ClienteHTTP1 {
  static String nombre_servidor;
  static Socket s;
  static ScannerRedes entrada;
  static PrintWriter salida;
  

  public static void envia_peticion(String objeto) {
        salida.print("GET " + objeto + " HTTP/1.1\r\n");
        salida.print("Host: " + nombre_servidor + "\r\n");
        salida.print("Connection: close\r\n\r\n");
        salida.flush();
  }

  public static void lee_linea_estado() {
    System.out.println(">>>>>>>>>>>>>>> LINEA DE ESTADO <<<<<<<<<<<<<<<");

  }

  public static void lee_cabeceras() {
    System.out.println(">>>>>>>>>>>>>>>    CABECERAS    <<<<<<<<<<<<<<<");

  }

  public static void lee_cuerpo_texto() {
    System.out.println(">>>>>>>>>>>>>>>   CUERPO TEXTO  <<<<<<<<<<<<<<<");

  }

  public static void lee_cuerpo_binario(String nombre_fichero) {
    System.out.println(">>>>>>>>>>>>>>>  CUERPO BINARIO <<<<<<<<<<<<<<<");

  }



  public static void main(String args[]) throws Exception {
    nombre_servidor = "zoltar.redes.upv.es";
    s = new Socket(nombre_servidor, 80);
    entrada = new ScannerRedes(s.getInputStream());
    salida = new PrintWriter(s.getOutputStream());
    
    envia_peticion("/");
    //envia_peticion("/oto1.jpg");
    lee_linea_estado();
    lee_cabeceras();
    lee_cuerpo_texto();
    //lee_cuerpo_binario("oto1.jpg");

    s.close();
  }
}
