package domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Weapon {
    private Long id;
    private int gear;
    private int gold;
    private int itemId;
    private int lv;

    public Weapon() {}

    @Builder
    public Weapon(Long id, int gear, int gold, int itemId, int lv) {
        this.id = id;
        this.gear = gear;
        this.gold = gold;
        this.itemId = itemId;
        this.lv = lv;
    }
}
