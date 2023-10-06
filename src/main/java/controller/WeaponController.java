package controller;

import domain.Weapon;
import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;
import service.WeaponService;

public class WeaponController {
    private InVillageController inVillageController = null;
    private WeaponService weaponService = null;
    private PlayerStatusService playerStatusService = null;
    public WeaponController(PlayerStatusService playerStatusService,WeaponService weaponService) {
        this.playerStatusService = playerStatusService;
        this.weaponService = weaponService;
        inVillageController = new InVillageController(playerStatusService);
    }

    public int SmithMenu() {
        DialogReadService.getDialog("SmithBackGround");
        DialogReadService.getDialog("SmithUpgradeMenu");
        DialogReadService.getDialog("WrongDialog");
        CharactorDto charactorDto = new CharactorDto(playerStatusService.findById(1L));
        switch (SceneController.scan()) {
            case 1: {
                weaponService.UpgradeSword(charactorDto);
            }   break;
            case 2:
                weaponService.UpgradeArmor(charactorDto);
                break;
            case 3:

                break;
            default:
                SmithMenu();
        }
        return 3;
    }
}
