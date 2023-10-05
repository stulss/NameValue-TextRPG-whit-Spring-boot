package dto;

import domain.Weapon;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeaponDto {
    private Long id;
    private int gear;
    private int gold;
    private int itemId;
    private int lv;

    public WeaponDto() {}

    @Builder
    public WeaponDto(Weapon weapon) {
        this.id = weapon.getId();
        this.gear = weapon.getGear();
        this.gold = weapon.getGold();
        this.itemId = weapon.getItemId();
        this.lv = weapon.getLv();
    }

    public Weapon toEntity() {
        return Weapon.builder()
                .id(id)
                .gear(gear)
                .gold(gold)
                .itemId(itemId)
                .lv(lv)
                .build();
    }
}

