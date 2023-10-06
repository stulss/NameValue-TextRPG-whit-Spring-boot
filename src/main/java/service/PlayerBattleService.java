package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Charactor;
import dto.CharactorDto;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PlayerBattleService {

    private PlayerStatusService playerStatusService = null;
    private List<Integer> monsters;
    private int dungeonGold;

    public PlayerBattleService(PlayerStatusService playerStatusService) {
        this.playerStatusService = playerStatusService;
        monsters = new LinkedList<>();
        dungeonGold = 0;
    }

    public void attackSquence(CharactorDto player, CharactorDto enemy){
        if(player.getSpeed() > enemy.getSpeed())
            action(player,enemy);
        else
            action(enemy,player);
    }

    public void action(CharactorDto player,CharactorDto enemy){
        turn(player,enemy, attack(player,enemy));
        if (enemy.getHp() > 0)
            turn(enemy,player, attack(enemy,player));
    }

    public void turn(CharactorDto attacker,CharactorDto enemy,int damage){
        attackMessage(attacker,enemy,damage);
        playerStatusService.HpChange(enemy,damage);
    }

    public int attack(CharactorDto attacker, CharactorDto enemy) {
        int damage = attacker.getAtk() - enemy.getDef();
        if(damage < 1) damage = 1;
        return - damage;
    }

    public int deffence(CharactorDto enemy, CharactorDto deffencer){
        int damage = (enemy.getAtk() - deffencer.getDef() + 1) / 2;
        if(damage < 1) damage = 1;
        return - damage;
    }

    public void attackMessage(CharactorDto attacker,CharactorDto enemy,int damage){
        System.out.print(attacker.getName());
        DialogReadService.getDialog("AttackDialog1");
        System.out.print(enemy.getName());
        DialogReadService.getDialog("AttackDialog2");
        System.out.print(damage);
        DialogReadService.getDialog("AttackDialog3");
    }

    public int dead() {
        if (playerStatusService.findById(1L).getHp() == 0) {
            System.out.print(playerStatusService.findById(1L).getName());
            DialogReadService.getDialog("BadEnding");
            System.exit(0);
        } else if (playerStatusService.findById(2L).getHp() > 0) {
            return 5;
        }
        System.out.print(playerStatusService.findById(2L).getName());
        DialogReadService.getDialog("MobDeadDialog");
        return 6;
    }

    public int runAway() {
        if (playerStatusService.findById(2L).getName().equals("리치왕 아서스 메놀드")) {
            DialogReadService.getDialog("LichRunAwayDialog");
            return 5;
        } else {
            return 1;
        }
    }

    public void updateMonster(int id){
        try {
            File file = new File("C:\\Users\\G\\Desktop\\namevalue2\\src\\main\\java\\Monster.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Charactor> monsterList = objectMapper.readValue(file, new TypeReference<>(){});
            CharactorDto monster = new CharactorDto(monsterList.get(id));
            monster.setId(2L);
            playerStatusService.update(monster);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public int nextMonster() {
        if (monsters.isEmpty()) {
            if (playerStatusService.findById(2L).getName().equals("리치왕 아서스 메놀드")) {
                DialogReadService.getDialog("TrueEnding");
                System.exit(0);
            }
            System.out.print(dungeonGold);
            DialogReadService.getDialog("EarnGold");
            playerStatusService.GoldChange(new CharactorDto(playerStatusService.findById(1L)), dungeonGold);
            DialogReadService.getDialog("VillageBackGround");
            return 1;
        }
        updateMonster(monsters.get(0));
        System.out.print(playerStatusService.findById(2L).getName());
        DialogReadService.getDialog("MobEntranceDialog");
        monsters.remove(0);
        return 5;

    }

    public void dungeonMaker(int[] mon,int gold){
        for (int i : mon){
            monsters.add(i);
        }
        dungeonGold = gold;
    }
}
