package service;

import domain.Weapon;
import dto.WeaponDto;
import repository.WeaponRepository;

import java.util.List;
public class WeaponService {
    private WeaponRepository weaponRepository = null;

    public WeaponService() {
        weaponRepository = new WeaponRepository();
        weaponRepository.createWeaponTable();
    }

    public void UpgradeSword() {

    }

}
