package service;

import domain.Weapon;
import dto.CharactorDto;
import repository.CharactorRepository;
import repository.WeaponRepository;

public class WeaponService {
    private WeaponRepository weaponRepository = null;
    private PlayerStatusService playerStatusService = null;
    DialogReadService dialogReadService = new DialogReadService();

    public WeaponService(PlayerStatusService playerStatusService) {
        playerStatusService = new PlayerStatusService();
        weaponRepository = new WeaponRepository();
        weaponRepository.createWeaponTable();
        weaponRepository.weaponInitialize();
    }

    public void UpgradeSword(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(0, charactorDto.toEntity().getSwordLv() + 1);
        if (weapon == null) {
            dialogReadService.titleDialog();
        } else if (playerStatusService.GoldChange(charactorDto,weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setAtk(weapon.getGear());
            temp.setSwordLv(weapon.getLv());
            playerStatusService.update(charactorDto);
            dialogReadService.smithSwordUpgradeDialog();
            System.out.print(playerStatusService.findById(1L).getAtk());
            dialogReadService.lineDialog();
        }
    }

    public void UpgradeArmor(CharactorDto charactorDto) {
        Weapon weapon = weaponRepository.findByItemIdLv(1, charactorDto.toEntity().getArmorLv() + 1);
        if (weapon == null) {
            dialogReadService.bSmithCannotDialog();
        } else if (playerStatusService.GoldChange(charactorDto,weapon.getGold())) {
            CharactorDto temp = new CharactorDto(charactorDto.toEntity());
            temp.setDef(weapon.getGear());
            temp.setArmorLv(weapon.getLv());
            playerStatusService.update(charactorDto);
            dialogReadService.smithArmorUpgradeDialog();
            System.out.print(playerStatusService.findById(1L).getDef());
            dialogReadService.lineDialog();
        }
    }
}
