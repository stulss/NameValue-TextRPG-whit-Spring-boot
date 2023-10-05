package controller;

import domain.Weapon;
import service.DialogReadService;
import service.WeaponService;

public class WeaponController {
    private WeaponService weaponService = null;
    private DialogReadService dialogReadService = new DialogReadService();

    public WeaponController() {
        weaponService = new WeaponService();
    }

    public void SmithMenu() {
        String smithControllerDialog = dialogReadService.getDialog("SmithBackGround");
        String smithMenuDialog = dialogReadService.getDialog("SmithUpgradeMenu");
        switch (scanner.scan) {
            case 1:
                weaponService.upgradeSword(CharactorDto);
                break;
            case 2:
                weaponService.upgradeArmor(CharactorDto);
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
