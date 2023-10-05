package controller;

import service.DialogReadService;

public class GameController {

    private DialogReadService dialogReadService = new DialogReadService();

    public void GameStory() {
        String gameStoryDialog = dialogReadService.getDialog("GameStoryDialog");

        if (gameStoryDialog != null) {
            System.out.println("키 'GameStoryDialog' 가 해당 JSON file에 있지 않습니다.");
        }
    }

    public void IntroMenu() {
        GameStory();
        while (true) {
            String gameControllerDialog = dialogReadService.getDialog("GameStoryMenu");
            switch (SceneController.scan()) {
                case 1:
                    InVillageController.selective();
                    break;
                case 2:
                    break;
                default:
                    gameControllerDialog = dialogReadService.getDialog("WrongDialog");
            }
            if (gameControllerDialog != null) {
                System.out.println("키 'GameStoryMenu' 가 해당 JSON file에 있지 않습니다.");
            }
        }
    }
}