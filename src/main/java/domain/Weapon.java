package domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Weapon {
    private Long id;
    private int sword;
    private int armor;
    private int swordGold;
    private int armorGold;
    private int lv;

    public Weapon() {}

    @Builder
    public Weapon(Long id, int sword, int armor, int swordGold, int armorGold, int lv) {
        this.id = id;
        this.sword = sword;
        this.armor = armor;
        this.swordGold = swordGold;
        this.armorGold = armorGold;
        this.lv = lv;
    }
}
