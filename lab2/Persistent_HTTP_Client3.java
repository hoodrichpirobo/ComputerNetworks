import java.net.*;
import java.io.*;
import java.util.*;

class Persistent_HTTP_Client4 {
  static String nombre_servidor;
  static Socket s;
  static ScannerRedes entrada;
  static PrintWriter salida;
  static InputStream is;
  static int longitud_cuerpo = 0;

  public static void envia_peticion(String objeto) {
        salida.print("GET " + objeto + " HTTP/1.1\r\n");
        salida.print("Host: " + nombre_servidor + "\r\n");
        salida.print("Connection: keep-alive\r\n\r\n");
        salida.flush();
  }

  public static void lee_linea_estado() {
    System.out.println(">>>>>>>>>>>>>>> LINEA DE ESTADO <<<<<<<<<<<<<<<");
    System.out.println(entrada.nextLine());
  }

  public static int extrae_entero(String cadena) {
    String tmp = cadena.replaceAll("[^0-9]", "");
    return Integer.parseInt(tmp);
  }

  public static void lee_cabeceras() {
    System.out.println(">>>>>>>>>>>>>>>    CABECERAS    <<<<<<<<<<<<<<<");
    String line;
    while(!(line = entrada.nextLine()).isEmpty()){
            System.out.println(line);
            if(line.startsWith("Content-Length")) {
                longitud_cuerpo = extrae_entero(line);
            }
    }
  }

  public static void lee_cuerpo_texto() throws IOException {
    System.out.println(">>>>>>>>>>>>>>>   CUERPO TEXTO  <<<<<<<<<<<<<<<");
    byte[] buffer = new byte[logitud_cuerpo];
    is.read(buffer, 0, longitud_cuerpo);
    System.out.println(new String(buffer, "UTF-8"));
  }

  public static void lee_cuerpo_binario(String nombre_fichero) throws IOException {
    System.out.println(">>>>>>>>>>>>>>>  CUERPO BINARIO <<<<<<<<<<<<<<<");
    FileOutputStream file = new FileOutputStream(nombre_fichero);
    int i;
    for(i = 0; i < longitud_cuerpo; i++){
        int carac = is.read();
        file.write(carac);
    }
    System.out.println("Bytes received: " + i);
    file.close();
  }

  public static void main(String args[]) throws Exception {
    nombre_servidor = "zoltar.redes.upv.es";
    s = new Socket(nombre_servidor, 80);
    is = s.getInputStream();
    entrada = new ScannerRedes(is);
    salida = new PrintWriter(s.getOutputStream());

    String[] resources = {"/", "/oto1.jpg", "/oto2.jpg"};

    for(String each : resources){
        envia_peticion(each);
        lee_linea_estado();
        lee_cabeceras();
        if(each.endsWith(".jpg")){
            lee_cuerpo_binario(each.substring(1));
        }else{
            lee_cuerpo_texto();
        }
    }

    s.close();
  }
}
