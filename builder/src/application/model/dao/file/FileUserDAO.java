package application.model.dao.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import application.model.bean.RoleUser;
import application.model.bean.User;
import application.model.dao.UserDAO;

public class FileUserDAO implements UserDAO {
	
	private static final String FILE_PATH = "data/users.csv";
    private static final String HEADER = "email,password,name,surname,role,team";
    
    public FileUserDAO() {
    	FileUtils.ensureFileExists(FILE_PATH, HEADER);
    }

	@Override
	public User findByEmail(String email) {
		
		User user = null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email)) { 
                    user = new User(parts[0], parts[1], parts[2], parts[3], RoleUser.valueOf(parts[4]), parts[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user; 
	}

	@Override
	public void saveUser(User user) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = String.format("%s,%s,%s,%s,%s,%s",
                    user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getRole(), user.getTeam());
            writer.write(line);
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public boolean isCoachAlreadyAssigned(String teamName) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Salta l'header

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length < 6) continue; 

                String userTeam = fields[5].trim();
                RoleUser role = RoleUser.valueOf(fields[4].trim().toUpperCase());

                if (userTeam.equalsIgnoreCase(teamName) && role == RoleUser.COACH) {
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; 
    }

}
