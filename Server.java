import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5000; // Server port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = serverSocket.accept(); // Accept incoming connection

            // Read encrypted data from the socket
            InputStream inputStream = socket.getInputStream();
            byte[] encryptedData = inputStream.readAllBytes();
            socket.close();

            // Define a 16-byte key for AES (must be kept secret)
            byte[] key = "1234567890abcdef".getBytes(); // 16 bytes key for AES

            // Decrypt the received data
            byte[] decryptedData = AESUtility.decrypt(encryptedData, key);

            // Save the decrypted data to a file
            try (FileOutputStream fos = new FileOutputStream("decrypted_file.txt")) {
                fos.write(decryptedData);
                System.out.println("Decrypted file saved as decrypted_file.txt");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
