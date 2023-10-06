package controller;

import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;
import service.WeaponService;

public class GameController {
    private PlayerStatusService playerStatusService = null;

    public GameController(PlayerStatusService playerStatusService) {
        this.playerStatusService = playerStatusService;
    }

    public void GameStory() {
        DialogReadService.getDialog("GameStoryDialog");
        boolean keep = true;
        while (keep) {
            DialogReadService.getDialog("GameStoryMenu");
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
                    DialogReadService.getDialog("WrongDialog");
            }
        }
    }
}