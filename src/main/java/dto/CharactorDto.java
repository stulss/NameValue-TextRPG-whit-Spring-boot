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
    }

    public Charactor toEntity(){
        return Charactor.builder()
                .name(name)
                .maxHp(maxHp)
                .hp(hp)
                .atk(atk)
                .def(def)
                .speed(speed)
                .gold(gold)
                .build();
    }
}
