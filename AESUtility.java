import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AESUtility {

    // Method to encrypt a file
    public static byte[] encrypt(byte[] fileData, byte[] key) throws Exception {
        // Generate a random IV
        byte[] iv = new byte[16]; // AES block size is 16 bytes
        new SecureRandom().nextBytes(iv); // Fill the IV with random bytes
        IvParameterSpec ivParams = new IvParameterSpec(iv);

        // Create cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // AES in CBC mode with PKCS5 padding
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES"); // Create secret key from the provided key
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams); // Initialize cipher for encryption

        // Encrypt data
        byte[] encrypted = cipher.doFinal(fileData); // Encrypt the byte array of the file data

        // Combine IV and encrypted data
        byte[] combined = new byte[iv.length + encrypted.length]; // Create a new array to hold IV and encrypted data
        System.arraycopy(iv, 0, combined, 0, iv.length); // Copy IV into the combined array
        System.arraycopy(encrypted, 0, combined, iv.length, encrypted.length); // Copy encrypted data into the combined array

        return combined; // Return combined byte array
    }

    // Method to decrypt a file
    public static byte[] decrypt(byte[] encryptedData, byte[] key) throws Exception {
        // Extract IV from the encrypted data
        byte[] iv = new byte[16]; // IV size is 16 bytes
        System.arraycopy(encryptedData, 0, iv, 0, iv.length); // Copy IV from the beginning of the encrypted data

        // The rest is the encrypted data
        byte[] encryptedBytes = new byte[encryptedData.length - iv.length]; // Create a new array for the encrypted data
        System.arraycopy(encryptedData, iv.length, encryptedBytes, 0, encryptedBytes.length); // Copy encrypted data

        // Create cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Use the same cipher configuration for decryption
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES"); // Create secret key from the provided key
        IvParameterSpec ivParams = new IvParameterSpec(iv); // Create IV parameter spec from the extracted IV
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams); // Initialize cipher for decryption

        // Decrypt data
        byte[] decrypted = cipher.doFinal(encryptedBytes); // Decrypt the encrypted data
        return decrypted; // Return the decrypted byte array
    }
}
