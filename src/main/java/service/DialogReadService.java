package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class DialogReadService {

    private String getDialog(String key) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, String> dialogMap =
                    mapper.readValue(Paths.get("../Dialog.json").toFile(), Map.class);
            return dialogMap.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printDialog(String dialogKey) {
        String dialog = DialogReadService.getDialog(dialogKey);

        if (dialog != null) {
            System.out.println(dialog);
        }
        else {
            System.out.println("해당 키에 대한 다이얼로그가 JSON 파일에 없습니다: " + dialogKey);
        }
    }

    public void titleDialog() { String dialogKey = "TitleDialog"; }

    public void inputName() {
        String dialogKey = "InputName";
    }

    public void wrongDialog() {
        String dialogKey = "WrongDialog";
    }
    public void selectMenuDialog() {
        String dialogKey = "SelectMenuDialog";
    }
    public void errorDelayDialog() {
        String dialogKey = "ErrorDelayDialog";
    }
    public void gameStoryDialog() {
        String dialogKey = "GameStoryDialog";
    }
    public void gameStoryMenu() {
        String dialogKey = "GameStoryMenu";
    }
    public void poorDialog() {
        String dialogKey = "PoorDialog";
    }
    public void villageBackGround() {
        String dialogKey = "VillageBackGround";
    }
    public void villageMenuDialog() {
        String dialogKey = "VillageMenuDialog";
    }
    public void pubBackGround() {
        String dialogKey = "PubBackGround";
    }
    public void pubMenuDialog() {
        String dialogKey = "PubMenuDialog";
    }
    public void restaurantBackGround() {
        String dialogKey = "RestaurantBackGround";
    }
    public void smithBackGround() {
        String dialogKey = "SmithBackGround";
    }
    public void bSmithCannotDialog() {
        String dialogKey = "BsmithCannotDialog";
    }
    public void smithUpgradeMenu() {
        String dialogKey = "SmithUpgradeMenu";
    }
    public void smithSwordUpgradeDialog() {
        String dialogKey = "SmithSwordUpgradeDialog";
    }
    public void smithArmorUpgradeDialog() {
        String dialogKey = "SmithArmorUpgradeDialog";
    }
    public void lineDialog() {
        String dialogKey = "LineDialog";
    }
    public void warMenuDialog() {
        String dialogKey = "WarMenuDialog";
    }
    public void mobEntranceDialog() {
        String dialogKey = "MobEntranceDialog";
    }
    public void dungeonMenuDialog() {
        String dialogKey = "DungeonMenuDialog";
    }
    public void enterGoblinDialog() {
        String dialogKey = "EnterGoblinDialog";
    }
    public void enterOrkDialog() {
        String dialogKey = "EnterOrkDialog";
    }
    public void enterNightElf() {
        String dialogKey = "EnterNightElf";
    }
    public void earnGold() {
        String dialogKey = "EarnGold";
    }
    public void badEnding() {
        String dialogKey = "BadEnding";
    }
    public void trueEnding() {
        String dialogKey = "TrueEnding";
}