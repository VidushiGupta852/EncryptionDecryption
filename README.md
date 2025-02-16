# Network-Based File Encryption Tool

## Overview
This project implements a **network-based file encryption tool** that allows users to securely encrypt, transfer, and decrypt files over a network. It ensures **data confidentiality and security** during transmission using **AES (Advanced Encryption Standard)** encryption.

## Features
- **File Encryption:** Encrypts files using AES encryption before transmission.
- **Secure Transmission:** Transfers encrypted files over a network using socket programming.
- **File Decryption:** Decrypts received files using the same AES algorithm.
- **Client-Server Model:** Uses a client-server architecture for communication and file transfer.

## Technologies Used
- **Java** (for implementation)
- **Java Cryptography Architecture (JCA)** (for encryption & decryption)
- **Socket Programming** (for network communication)

## Hardware & Software Requirements
- **Operating System:** Windows 7 or later
- **RAM:** Minimum 3GB
- **Hard Disk:** Minimum 320GB
- **Java Development Kit (JDK)** (Latest version recommended)
- **IDE:** VS Code, IntelliJ IDEA, or Eclipse (Optional)

## Project Structure
```
📂 
 ├── 📜 AESUtility.java (Handles encryption & decryption)
 ├── 📜 Client.java (Client-side implementation)
 ├── 📜 Server.java (Server-side implementation)
 ├── 📜 README.md (Project documentation)
```

## How to Run the Project
### Step 1: Compile the Java Files
Navigate to the project directory and compile the Java files:
```sh
javac AESUtility.java Client.java Server.java
```

### Step 2: Start the Server
Run the server first to listen for incoming connections:
```sh
java Server
```

### Step 3: Run the Client
Open another terminal window and run the client to send an encrypted file:
```sh
java Client
```

### Step 4: Decryption
The server receives the encrypted file and decrypts it back to its original form.

## Expected Output
- **Input File (Before Encryption):** Original readable content.
- **Encrypted File:** Unreadable ciphertext.
- **Decrypted File:** Matches the original file.

## Security Considerations
- Uses AES with a **secure key** and **CBC mode** for encryption.
- Ensures **data integrity** by sending only encrypted files.
- Supports **confidential transmission** over an unsecured network.

## Future Enhancements
- Implementing **RSA encryption** for secure key exchange.
- Adding **multi-client support** for encrypted file sharing.
- Enhancing **GUI support** for better usability.
  
## License
This project is licensed under the MIT License.

## Author
Developed by Vidushi Gupta



