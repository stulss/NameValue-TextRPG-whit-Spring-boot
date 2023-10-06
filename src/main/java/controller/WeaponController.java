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

    public int SmithMenu() {
        weaponService.smithMenu();
        CharactorDto charactorDto = new CharactorDto(playerStatusService.findById(1L));
        switch (SceneController.scan()) {
            case 1: {
                weaponService.UpgradeSword(charactorDto);
            }   break;
            case 2:
                weaponService.UpgradeArmor(charactorDto);
                break;
            case 3:
                DialogReadService.getDialog("VillageBackGround");
                return 1;
            default:
                DialogReadService.getDialog("WrondDialog");
                break;
        }
        return 3;
    }
}
