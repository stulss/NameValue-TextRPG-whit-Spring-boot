package dto;

import domain.Weapon;

import lombok.Builder;
import lombok.Data;


@Data
public class WeaponDto {
    private Long id;
    private int sword;
    private int armor;
    private int swordGold;
    private int armorGold;
    private int lv;

    public WeaponDto() {}

    @Builder
    public WeaponDto(Weapon weapon) {
        this.id = weapon.getId();
        this.sword = weapon.getSword();
        this.armor = weapon.getArmor();
        this.swordGold = weapon.getSwordGold();
        this.armorGold = weapon.getArmorGold();
        this.lv = weapon.getLv();
    }

    public Weapon toEntity() {
        return Weapon.builder()
                .id(id)
                .sword(sword)
                .armor(armor)
                .swordGold(swordGold)
                .armorGold(armorGold)
                .lv(lv)
                .build();
    }
}

