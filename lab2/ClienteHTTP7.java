import java.net.*;
import java.io.*;
import java.util.*;

class ClienteHTTP7 {
  static String nombre_servidor;
  static Socket s;
  static ScannerRedes entrada;
  static PrintWriter salida;
  static InputStream is;

  public static void envia_peticion(String objeto) {
        salida.print("GET " + objeto + " HTTP/1.1\r\n");
        salida.print("Host: " + nombre_servidor + "\r\n");
        salida.print("Connection: close\r\n\r\n");
        salida.flush();
  }

  public static void lee_linea_estado() {
    System.out.println(">>>>>>>>>>>>>>> LINEA DE ESTADO <<<<<<<<<<<<<<<");
    System.out.println(entrada.nextLine());
  }

  public static void lee_cabeceras() {
    System.out.println(">>>>>>>>>>>>>>>    CABECERAS    <<<<<<<<<<<<<<<");
    String line;
    while(!(line = entrada.nextLine()).isEmpty()){
            System.out.println(line);
    }
  }

  public static void lee_cuerpo_texto() {
    System.out.println(">>>>>>>>>>>>>>>   CUERPO TEXTO  <<<<<<<<<<<<<<<");
    while(entrada.hasNext()){
        System.out.println(entrada.nextLine());
    }
  }

  public static void lee_cuerpo_binario(String nombre_fichero) throws IOException {
    System.out.println(">>>>>>>>>>>>>>>  CUERPO BINARIO <<<<<<<<<<<<<<<");
    FileOutputStream file = new FileOutputStream(nombre_fichero);
    int counter = 0;
    int carac;
    while((carac = is.read()) != -1){
        counter++;
        System.out.print(carac);
        file.write(carac);
    }
    System.out.println("\nCounter: " + counter);
    file.close();
  }



  public static void main(String args[]) throws Exception {
    nombre_servidor = "zoltar.redes.upv.es";
    String[] resources = {"/", "/oto1.jpg", "/oto2.jpg"};

    for(String each : resources){
        s = new Socket(nombre_servidor, 80);
        is = s.getInputStream();
        entrada = new ScannerRedes(is);
        salida = new PrintWriter(s.getOutputStream());

        envia_peticion(each);
        lee_linea_estado();
        lee_cabeceras();
        if(each.endsWith(".jpg")){
            lee_cuerpo_binario(each.substring(1));
        }else{
            lee_cuerpo_texto();
        }
        s.close();
        salida.close();
    }
  }
}
