package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class DialogReadService {
    public static void getDialog(String key) {
        try{
            File file = new File("C:\\Users\\G\\Desktop\\NameValue_TextRPG_Spring_Pakage_Structure\\src\\main\\java\\Dialog.json");
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String[]> dialog = objectMapper.readValue(file, new TypeReference<>() {});
            if (dialog != null) {
                for (String e : dialog.get(key)){
                    System.out.print(e);
                }
            }
            else {
                System.out.println("해당 키에 대한 다이얼로그가 JSON 파일에 없습니다: " + key);
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}