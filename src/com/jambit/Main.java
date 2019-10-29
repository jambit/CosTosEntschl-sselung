package com.jambit;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        InputReader inputReader = new InputReader();
        final StringArray fileContent = inputReader.readFile("EncryptedText.txt");

        UserInterface userInterface = new UserInterface();
        userInterface.enterKey();

        DecryptionHelper decryptionHelper = new DecryptionHelper();
        StringArray decryptFileContent;
        if (userInterface.seed != 0) {
            decryptFileContent = decryptionHelper.decrypt(fileContent, userInterface.key,
                    userInterface.seed);
        } else {
            decryptFileContent = decryptionHelper.decrypt(fileContent, userInterface.key);
        }

        // prints out the decrypted text
        for (int i = 0; i < decryptFileContent.getSize(); i++) {
            System.out.println(decryptFileContent.get(i));
        }
    }
}
