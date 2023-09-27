package domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Charactor {
    private Long id;
    private String name = null;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private int speed;
    private int gold;

    public Charactor() {}

    @Builder
    public Charactor(Long id,String name, int maxHp, int hp, int atk, int def, int speed, int gold) {
        this.id = id;
        this.name = name;
        this.maxHp = maxHp;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
        this.gold = gold;
    }
}
