import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Server IP
        int port = 5000; // Server port
        String filePath = "C:\\Users\\DELL\\OneDrive\\Desktop\\cn pro\\vidushi"; // Path to the file to be sent

        try {
            // Define a 16-byte key for AES (must be shared with the server)
            byte[] key = "1234567890abcdef".getBytes(); // 16 bytes key for AES

            // Read the file into a byte array
            File file = new File(filePath);
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileData);
            fis.close();

            // Encrypt the file data
            byte[] encryptedData = AESUtility.encrypt(fileData, key);
            System.out.println("Encrypted data ready to be sent.");

            // Convert encrypted data to Base64 for display
            String ciphertext = Base64.getEncoder().encodeToString(encryptedData);
            System.out.println("Ciphertext (Base64): " + ciphertext); // Print ciphertext

            // Create socket and send encrypted data
            try (Socket socket = new Socket(host, port);
                 OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(encryptedData);
                outputStream.flush();
                System.out.println("Encrypted file sent to the server.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
