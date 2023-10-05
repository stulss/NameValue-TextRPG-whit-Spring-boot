package controller;

import domain.Weapon;
import dto.CharactorDto;
import service.DialogReadService;
import service.WeaponService;

public class WeaponController {
    private WeaponService weaponService = null;
    private CharactorDto charactorDto = null;
    private DialogReadService dialogReadService = new DialogReadService();

    public WeaponController() {
        charactorDto = new CharactorDto();
        weaponService = new WeaponService();
    }

    public void SmithMenu() {
        String smithControllerDialog = dialogReadService.getDialog("SmithBackGround");
        String smithMenuDialog = dialogReadService.getDialog("SmithUpgradeMenu");
        switch (scanner.scan) {
            case 1:
                weaponService.UpgradeSword(charactorDto);
                break;
            case 2:
                weaponService.UpgradeArmor(charactorDto);
                break;
            case 3:
                InVillageController.selective();
                break;
            default:
                smithControllerDialog = dialogReadService.getDialog("WrongDialog");
                SmithMenu();
        }
        if (smithControllerDialog != null) {
            System.out.println("키 'GameStoryMenu' 가 해당 JSON file에 있지 않습니다.");
        }
    }
}
