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

//    private static String getDialog(String key) {
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            Map<String, Object> dialogMap =
//                    mapper.readValue(Paths.get("C:\\Users\\G\\Desktop\\NameValue_TextRPG_Spring_Pakage_Structure\\src\\main\\java\\Dialog.json").toFile(), Map.class);
//            Object value = dialogMap.get(key);
//
//            if (value instanceof List<?>) {
//                // If the value is a list, join all items into a single string without brackets and commas.
//                return String.join("\n", (List<String>) value);
//            } else {
//                return value != null ? value.toString() : null;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//


    public void titleDialog() {
        getDialog("TitleDialog"); 
    }

    public void inputName() {
        getDialog("InputName");
    }

    public void wrongDialog() {
        getDialog("WrongDialog");
    }
    public void selectMenuDialog() {
        getDialog("SelectMenuDialog");
    }
    public void errorDelayDialog() {
        getDialog("ErrorDelayDialog");
    }
    public void gameStoryDialog() {
        getDialog("GameStoryDialog");
    }
    public void gameStoryMenu() {
        getDialog("GameStoryMenu");
    }
    public void poorDialog() {
        getDialog("PoorDialog");
    }
    public void villageBackGround() {
        getDialog("VillageBackGround");
    }
    public void villageMenuDialog() {
        getDialog("VillageMenuDialog");
    }
    public void pubBackGround() {
        getDialog("PubBackGround");
    }
    public void pubMenuDialog() {
        getDialog("PubMenuDialog");
    }
    public void restaurantBackGround() {
        getDialog("RestaurantBackGround");
    }
    public void smithBackGround() {
        getDialog("SmithBackGround");
    }
    public void bSmithCannotDialog() {
        getDialog("BsmithCannotDialog");
    }
    public void smithUpgradeMenu() {
        getDialog( "SmithUpgradeMenu");
    }
    public void smithSwordUpgradeDialog() {
        getDialog("SmithSwordUpgradeDialog");
    }
    public void smithArmorUpgradeDialog() {
        getDialog( "SmithArmorUpgradeDialog");
    }
    public void lineDialog() {
        getDialog("LineDialog");
    }
    public void warMenuDialog() {
        getDialog("WarMenuDialog");
    }
    public void mobEntranceDialog() {
        getDialog("MobEntranceDialog");
    }
    public void dungeonMenuDialog() {
        getDialog("DungeonMenuDialog");
    }
    public void enterGoblinDialog() {
        getDialog("EnterGoblinDialog");
    }
    public void enterOrkDialog() {
        getDialog("EnterOrkDialog");
    }
    public void enterNightElf() {
        getDialog("EnterNightElf");
    }
    public void enterSnowMountainDialog() {
        getDialog("EnterSnowMountainDialog");
    }
    public void earnGold(){
        getDialog("EarnGold");
    }
    public void badEnding() {
        getDialog( "BadEnding");
    }
    public void trueEnding() {
        getDialog("TrueEnding");
    }

}