package application.config;

public class AppConfig {
    private static AppConfig instance;
    private String mode;

    private AppConfig(String mode) {
        this.mode = mode;
    }

    public static void init(String mode) {
        instance = new AppConfig(mode);
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            throw new IllegalStateException("AppConfig non inizializzato!");
        }
        return instance;
    }

    public String getMode() {
        return mode;
    }
}
