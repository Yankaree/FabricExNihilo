package ngcsonsplash.fabricaeexnihilo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.Coresync;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager<T> {
    private static final Logger LOGGER = LogManager.getLogger("FabricaeExNihiloConfig");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Path configPath;
    private final T defaultValue;
    private T currentConfig;

    public ConfigManager(T defaultValue, String fileName) {
        this.defaultValue = defaultValue;
        this.configPath = Paths.get("config", fileName + ".json");
        this.currentConfig = load();
    }

    @SuppressWarnings("unchecked")
    private T load() {
        try {
            if (Files.exists(configPath)) {
                Reader reader = Files.newBufferedReader(configPath);
                T loaded = gson.fromJson(reader, (Class<T>) defaultValue.getClass());
                reader.close();
                return loaded != null ? loaded : defaultValue;
            }
        } catch (Exception e) {
            LOGGER.error("Failed to load config, using defaults: " + e.getMessage());
        }
        return defaultValue;
    }

    public void save() {
        try {
            Files.createDirectories(configPath.getParent());
            Writer writer = Files.newBufferedWriter(configPath);
            gson.toJson(currentConfig, writer);
            writer.close();
        } catch (Exception e) {
            LOGGER.error("Failed to save config: " + e.getMessage());
        }
    }

    public T getConfig() {
        return currentConfig;
    }

    public void setConfig(T config) {
        this.currentConfig = config;
        save();
    }
}
