package service;

import domain.Weapon;
import dto.CharactorDto;
import repository.CharactorRepository;
import repository.WeaponRepository;

public class WeaponService {
    private WeaponRepository weaponRepository = null;
    private PlayerStatusService playerStatusService = null;

    public WeaponService(PlayerStatusService playerStatusService) {
        this.playerStatusService = playerStatusService;

        weaponRepository = new WeaponRepository();
        weaponRepository.createWeaponTable();
        weaponRepository.weaponInitialize();
    }

    public void UpgradeSword(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(0, charactorDto.toEntity().getSwordLv() + 1);
        if (weapon == null) {
            DialogReadService.getDialog("BsmithCannotDialog");
        } else if (playerStatusService.GoldChange(charactorDto,weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setAtk(weapon.getGear());
            temp.setSwordLv(weapon.getLv());
            playerStatusService.update(charactorDto);
            DialogReadService.getDialog("SmithSwordUpgradeDialog");
            System.out.print(playerStatusService.findById(1L).getAtk());
            DialogReadService.getDialog("SmithUpgradeDialog2");
        }
    }

    public void UpgradeArmor(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(1, charactorDto.toEntity().getArmorLv() + 1);
        if (weapon == null) {
            DialogReadService.getDialog("BsmithCannotDialog");
        } else if (playerStatusService.GoldChange(charactorDto,weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setDef(weapon.getGear());
            temp.setArmorLv(weapon.getLv());
            playerStatusService.update(charactorDto);
            DialogReadService.getDialog("SmithArmorUpgradeDialog");
            System.out.print(playerStatusService.findById(1L).getDef());
            DialogReadService.getDialog("SmithUpgradeDialog2");
        }
    }

    public void smithMenu(){
        DialogReadService.getDialog("SmithUpgradeMenu1");
        if (playerStatusService.findById(1L).getSwordLv() < 3) {
            System.out.print(weaponRepository.findByItemIdLv(0, playerStatusService.findById(1L).getSwordLv() + 1).getGold());
        }
        else{
            System.out.print("--");
        }
        DialogReadService.getDialog("SmithUpgradeMenu2");
        if (playerStatusService.findById(1L).getArmorLv() < 3) {
            System.out.print(weaponRepository.findByItemIdLv(1, playerStatusService.findById(1L).getArmorLv() + 1).getGold());
        }
        else{
            System.out.print("--");
        }
        DialogReadService.getDialog("SmithUpgradeMenu3");
    }

}
