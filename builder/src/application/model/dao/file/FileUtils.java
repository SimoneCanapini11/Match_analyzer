package application.model.dao.file;

import java.io.*;
import java.nio.file.*;
import java.util.Collections;

public class FileUtils {

	// Assicura che un file esista e abbia un'intestazione
    public static void ensureFileExists(String filePath, String header) {
    	
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                Files.createDirectories(Paths.get(file.getParent())); 
                Files.write(file.toPath(), Collections.singleton(header), StandardOpenOption.CREATE);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
