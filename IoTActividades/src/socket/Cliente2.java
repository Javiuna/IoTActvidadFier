package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente2 {
    private String ip;
    private int puerto;

    public Cliente2(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public String enviarMensaje(String mensaje) {
        try {
            // Conexión al servidor
            Socket socket = new Socket(ip, puerto);

            // Envío del mensaje al servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(mensaje);

            // Recepción de la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respuesta = in.readLine();

            // Cierre de la conexión
            socket.close();

            return respuesta;
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
            return null;
        }
    }
}
