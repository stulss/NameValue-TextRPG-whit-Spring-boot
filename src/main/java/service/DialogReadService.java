package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class DialogReadService {

    public static String getDialog(String key) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> dialogMap =
                    mapper.readValue(Paths.get("./Dialog.json").toFile(), Map.class);
            return dialogMap.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}