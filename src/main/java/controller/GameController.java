package controller;

import service.DialogReadService;

public class GameController {

    private DialogReadService dialogReadService = new DialogReadService();

    public void GameStory() {
        String gameControllerDialog = dialogReadService.getDialog("GameStoryDialog");

        if (gameControllerDialog != null) {
        } else {
            System.out.println("키 'GameStoryDialog' 가 해당 JSON file에 있지 않습니다.");
        }
    }
    public void Menu() {
        GameStory();
        String gameControllerDialog = dialogReadService.getDialog("GameStoryMenu");
        switch (scanner.scan) {
            case 1:
                InVillageController.selective();
                break;
            case 2:
                break;
            default:
                gameControllerDialog = dialogReadService.getDialog("WrongDialog");
                Menu();
        }
        if (gameControllerDialog != null) {
        } else {
            System.out.println("키 'GameStoryMenu' 가 해당 JSON file에 있지 않습니다.");
        }
    }
}