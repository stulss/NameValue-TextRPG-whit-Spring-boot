package controller;

import service.DialogReadService;
import service.PlayerStatusService;
import service.WeaponService;

public class GameController {
    private InVillageController inVillageController = null;

    public GameController(PlayerStatusService playerStatusService) {
        inVillageController = new InVillageController(playerStatusService);
    }

    private DialogReadService dialogReadService = new DialogReadService();

    public void GameStory() {
        dialogReadService.gameStoryDialog();
        while (true) {
            dialogReadService.gameStoryMenu();
            switch (SceneController.scan()) {
                case 1:
                    inVillageController.selective();
                    break;
                case 2:
                    break;
                default:
                    dialogReadService.wrongDialog();
            }
        }
    }
}