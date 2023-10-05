package service;

import domain.Weapon;
import dto.CharactorDto;
import repository.WeaponRepository;

public class WeaponService {
    private WeaponRepository weaponRepository = null;
    public void Update_atk(CharactorDto charactorDto){
        charactorRepository.update_atk(charactorDto.toEntity());
    }
    public void Update_def(CharactorDto charactorDto){
        chractorRepository.update_def(charactorDto.toEntity());
    }

    public WeaponService() {
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
            update_atk(temp);
            DialogReadService.getDialog("SmithSwordUpgradeDialog");
            System.out.print(findById(1L).getAtk());
            DialogReadService.getDialog("LineDialog");
            weaponRepository.weaponUpdate(CharactorDto.toEntity());
        }
    }

    public void UpgradeArmor(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(1, charactorDto.toEntity().getArmorLv() + 1);
        if (weapon == null) {
            DialogReadService.getDialog("BsmithCannotDialog");
        } else if (GoldChange(weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setDef(weapon.getGear());
            update_def(temp);
            DialogReadService.getDialog("SmithArmorUpgradeDialog");
            System.out.print(findById(1L).getDef());
            DialogReadService.getDialog("LineDialog");
            weaponRepository.weaponUpdate(CharactorDto.toEntity());
        }
    }
}
