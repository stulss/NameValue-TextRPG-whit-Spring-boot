package dto;

import domain.Weapon;

import lombok.Builder;
import lombok.Data;


@Data
public class WeaponDto {
    private Long id;
    private int sword;
    private int armor;
    private int gold;
    private int lv;

    public WeaponDto() {}

    @Builder
    public WeaponDto(Weapon weapon) {
        this.id = weapon.getId();
        this.gear = weapon.getGear();
        this.gold = weapon.getGold();
        this.lv = weapon.getLv();
    }

    public Weapon toEntity() {
        return Weapon.builder()
                .id(id)
                .gear(gear)
                .gold(gold)
                .lv(lv)
                .build();
    }
}

