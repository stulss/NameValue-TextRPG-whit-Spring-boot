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

    DialogReadService dialogReadService = new DialogReadService();
    private PlayerStatusService playerStatusService = null;
    private List<Integer> monsters;
    private int dungeonGold;

    public PlayerBattleService(PlayerStatusService playerStatusService) {
        this.playerStatusService = playerStatusService;
        monsters = new LinkedList<>();
        dungeonGold = 0;
    }

    public void attackSquence(CharactorDto player, CharactorDto enemy) {
        if (player.getSpeed() > enemy.getSpeed()) {
            attack(player, enemy);
            if (enemy.getHp() > 0)
                attack(enemy, player);
        }
        else {
            attack(enemy, player);
            if (player.getHp() > 0)
                attack(player, enemy);
        }
    }

    public void attack(CharactorDto player, CharactorDto enemy) {
        int dmg = player.getAtk() - enemy.getDef();
        if (dmg < 1) {dmg = 1;}
        if (enemy.getHp() > dmg) {
            enemy.setHp(enemy.getHp() - dmg);
        }
        else{
            enemy.setHp(0);
        }
        System.out.println(player.getName() + "(이)가 " + enemy.getName() + "에게 "
                + dmg + "만큼 데미지를 주었습니다. ");
        System.out.println(enemy.getName() + "의 현재 HP : " + enemy.getHp());

    }

    public void deffence(CharactorDto player, CharactorDto enemy){
        int dmg = (enemy.getAtk() - player.getDef() + 1) / 2;
        if (dmg < 1) {dmg = 1;}
        if (player.getHp() > dmg) {
            player.setHp(player.getHp() - dmg);
        }
        else{
            player.setHp(0);
        }
        System.out.println(enemy.getName() + "(이)가 " + player.getName() + "에게 "
                + dmg + "만큼 데미지를 주었습니다. ");
    }

    public int dead() {
        if (playerStatusService.findById(1L).getHp() == 0) {
            System.out.println(playerStatusService.findById(1L).getName()+"의 현재 HP는 0");
            System.out.print(playerStatusService.findById(1L).getName());
            dialogReadService.badEnding();
            System.exit(0);
        } else if (playerStatusService.findById(2L).getHp() > 0) {
            return 5;
        }
        System.out.print(playerStatusService.findById(2L).getName()+"(이)가 죽었습니다.");
        return 6;
    }

    public int runAway() {
        if (playerStatusService.findById(2L).getName().equals("리치왕 아서스 메놀드")) {
            System.out.println("도망칠 수 없음");
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
                dialogReadService.trueEnding();
                //DialogReadService.getDialog("TrueEnding");
                System.exit(0);
            }
            System.out.print(dungeonGold);
            dialogReadService.earnGold();
            playerStatusService.GoldChange(new CharactorDto(playerStatusService.findById(1L)), dungeonGold);
            return 1;
        }
        updateMonster(monsters.get(0));
        System.out.print(playerStatusService.findById(2L).getName());
        dialogReadService.mobEntranceDialog();
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
