package dto;

import domain.Charactor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CharactorDto {
    private Long id;
    private String name;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    private int speed;
    private int gold;
    private int swordLv;
    private int armorLv;

    public CharactorDto() {}

    public CharactorDto(Charactor charactor) {
        this.id = charactor.getId();
        this.name = charactor.getName();
        this.maxHp = charactor.getMaxHp();
        this.hp = charactor.getHp();
        this.atk = charactor.getAtk();
        this.def = charactor.getDef();
        this.speed = charactor.getSpeed();
        this.gold = charactor.getGold();
        this.swordLv = charactor.getSwordLv();
        this.armorLv = charactor.getArmorLv();
    }

    public Charactor toEntity(){
        return Charactor.builder()
                .id(id)
                .name(name)
                .maxHp(maxHp)
                .hp(hp)
                .atk(atk)
                .def(def)
                .speed(speed)
                .gold(gold)
                .swordLv(swordLv)
                .armorLv(armorLv)
                .build();
    }
}
