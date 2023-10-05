package service;

import domain.Weapon;
import dto.CharactorDto;
import repository.CharactorRepository;
import repository.WeaponRepository;

public class WeaponService {
    private CharactorRepository charactorRepository = null;
    private WeaponRepository weaponRepository = null;
    private PlayerStatusService playerStatusService = null;
    private CharactorDto charactorDto = null;
    public void UpdateAtkDef(CharactorDto charactorDto){
        charactorRepository.update(charactorDto.toEntity());
    }

    public WeaponService() {
        charactorDto = new CharactorDto();
        playerStatusService = new PlayerStatusService();
        charactorRepository = new CharactorRepository();
        weaponRepository = new WeaponRepository();
        weaponRepository.createWeaponTable();
        weaponRepository.weaponInitialize();
    }

    public void UpgradeSword(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(0, charactorDto.toEntity().getSwordLv() + 1);
        if (weapon == null) {
            DialogReadService.getDialog("BSmithCannotDialog");
        } else if (GoldChange(weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setAtk(weapon.getGear());
            UpdateAtkDef(temp);
            DialogReadService.getDialog("SmithSwordUpgradeDialog");
            System.out.print(playerStatusService.findById(1L).getAtk());
            DialogReadService.getDialog("LineDialog");
            weaponRepository.weaponUpdate(weapon);
        }
    }

    public void UpgradeArmor(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(1, charactorDto.toEntity().getArmorLv() + 1);
        if (weapon == null) {
            DialogReadService.getDialog("BsmithCannotDialog");
        } else if (GoldChange(weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setDef(weapon.getGear());
            UpdateAtkDef(temp);
            DialogReadService.getDialog("SmithArmorUpgradeDialog");
            System.out.print(playerStatusService.findById(1L).getDef());
            DialogReadService.getDialog("LineDialog");
            weaponRepository.weaponUpdate(weapon);
        }
    }
}
