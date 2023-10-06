package controller;

import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;
import service.WeaponService;

public class GameController {
    //private InVillageController inVillageController = null;
    private PlayerStatusService playerStatusService = null;

    public GameController(PlayerStatusService playerStatusService) {
        //inVillageController = new InVillageController(playerStatusService);
        this.playerStatusService = playerStatusService;
    }

    private DialogReadService dialogReadService = new DialogReadService();

    public void GameStory() {
        dialogReadService.gameStoryDialog();
        boolean keep = true;
        while (keep) {
            dialogReadService.gameStoryMenu();
            switch (SceneController.scan()) {
                case 1:
                    //inVillageController.selective();
                    keep = false;
                    CharactorDto charactorDto = new CharactorDto(playerStatusService.findById(1L));
                    charactorDto.setName(SceneController.scanName());
                    playerStatusService.update_name(charactorDto);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    dialogReadService.wrongDialog();
            }
        }
    }
}