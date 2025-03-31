package application.model.dao.file;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.*;
import java.util.Collections;

public class FileUtils {
	
	private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());
	
	private FileUtils() {}  

	// Assicura che un file esista e abbia un'intestazione
    public static void ensureFileExists(String filePath, String header) {
    	
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                Files.createDirectories(Paths.get(file.getParent())); 
                Files.write(file.toPath(), Collections.singleton(header), StandardOpenOption.CREATE);
                
            } catch (IOException e) {
            	LOGGER.log(Level.SEVERE, "Error creating file: ", e);
            }
        }
    }
}
