package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class DialogReadService {
    public static String getDialog(String key) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, Object> dialogMap =
                    mapper.readValue(Paths.get("C:\\Users\\G\\Desktop\\NameValue_TextRPG_Spring_Pakage_Structure\\src\\main\\java\\Dialog.json").toFile(), Map.class);
            Object value = dialogMap.get(key);

            if (value instanceof List<?>) {
                // If the value is a list, join all items into a single string without brackets and commas.
                return String.join("\n", (List<String>) value);
            } else {
                return value != null ? value.toString() : null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printDialog(String dialogKey) {
        String dialog = getDialog(dialogKey);

        if (dialog != null) {
            System.out.println(dialog);
        }
        else {
            System.out.println("해당 키에 대한 다이얼로그가 JSON 파일에 없습니다: " + dialogKey);
        }
    }


    public void titleDialog() { printDialog("TitleDialog"); }

    public void inputName() {
        printDialog("InputName");
    }

    public void wrongDialog() {
        printDialog("WrongDialog");
    }
    public void selectMenuDialog() {
        printDialog("SelectMenuDialog");
    }
    public void errorDelayDialog() {
        printDialog("ErrorDelayDialog");
    }
    public void gameStoryDialog() {
        printDialog("GameStoryDialog");
    }
    public void gameStoryMenu() {
        printDialog("GameStoryMenu");
    }
    public void poorDialog() {
        printDialog("PoorDialog");
    }
    public void villageBackGround() {
        printDialog("VillageBackGround");
    }
    public void villageMenuDialog() {
        printDialog("VillageMenuDialog");
    }
    public void pubBackGround() {
        printDialog("PubBackGround");
    }
    public void pubMenuDialog() {
        printDialog("PubMenuDialog");
    }
    public void restaurantBackGround() {
        printDialog("RestaurantBackGround");
    }
    public void smithBackGround() {
        printDialog("SmithBackGround");
    }
    public void bSmithCannotDialog() {
        printDialog("BsmithCannotDialog");
    }
    public void smithUpgradeMenu() {
        printDialog( "SmithUpgradeMenu");
    }
    public void smithSwordUpgradeDialog() {
        printDialog("SmithSwordUpgradeDialog");
    }
    public void smithArmorUpgradeDialog() {
        printDialog( "SmithArmorUpgradeDialog");
    }
    public void lineDialog() {
        printDialog("LineDialog");
    }
    public void warMenuDialog() {
        printDialog("WarMenuDialog");
    }
    public void mobEntranceDialog() {
        printDialog("MobEntranceDialog");
    }
    public void dungeonMenuDialog() {
        printDialog("DungeonMenuDialog");
    }
    public void enterGoblinDialog() {
        printDialog("EnterGoblinDialog");
    }
    public void enterOrkDialog() {
        printDialog("EnterOrkDialog");
    }
    public void enterNightElf() {
        printDialog("EnterNightElf");
    }
    public void enterSnowMountainDialog() { printDialog("EnterSnowMountainDialog");}
    public void earnGold() {
        printDialog("EarnGold");
    }
    public void badEnding() {
        printDialog( "BadEnding");
    }
    public void trueEnding() {
        printDialog("TrueEnding");
    }
}