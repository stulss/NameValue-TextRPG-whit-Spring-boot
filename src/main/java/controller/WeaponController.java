package controller;

import domain.Weapon;
import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;
import service.WeaponService;

public class WeaponController {
    private WeaponService weaponService = null;
    private PlayerStatusService playerStatusService = null;
    public WeaponController(PlayerStatusService playerStatusService,WeaponService weaponService) {
        this.playerStatusService = playerStatusService;
        this.weaponService = weaponService;
    }

    public void SmithMenu() {
        String smithControllerDialog = DialogReadService.getDialog("SmithBackGround");
        String smithMenuDialog = DialogReadService.getDialog("SmithUpgradeMenu");
        CharactorDto charactorDto = new CharactorDto(playerStatusService.findById(1L));
        switch (SceneController.scan()) {
            case 1: {
                weaponService.UpgradeSword(charactorDto);
            }   break;
            case 2:
                weaponService.UpgradeArmor(charactorDto);
                break;
            case 3:
                inVillageController.selective();
                break;
            default:
                smithControllerDialog = DialogReadService.getDialog("WrongDialog");
                SmithMenu();
        }
        if (smithControllerDialog != null) {
            System.out.println("키 'GameStoryMenu' 가 해당 JSON file에 있지 않습니다.");
        }
    }
}
