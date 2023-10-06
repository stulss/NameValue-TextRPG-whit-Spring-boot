package controller;

import dto.CharactorDto;
import repository.CharactorRepository;
import service.DialogReadService;
import service.PlayerBattleService;
import service.PlayerStatusService;

import java.util.Scanner;

public class BattleController {
    private PlayerBattleService playerBattleService = null;
    private PlayerStatusService playerStatusService = null;

    public BattleController(PlayerStatusService playerStatusService,PlayerBattleService playerBattleService) {
        this.playerBattleService = playerBattleService;
        this.playerStatusService = playerStatusService;
    }

    public int war() {
        DialogReadService.getDialog("WarMenuDialog");
        switch (SceneController.scan()) {
            case 1: {
                CharactorDto player = new CharactorDto(playerStatusService.findById(1L));
                CharactorDto monster = new CharactorDto(playerStatusService.findById(2L));
                playerBattleService.attackSquence(player, monster);
            }
            return playerBattleService.dead();
            case 2: {
                CharactorDto player = new CharactorDto(playerStatusService.findById(1L));
                CharactorDto monster = new CharactorDto(playerStatusService.findById(2L));
                playerBattleService.turn(monster,player,playerBattleService.deffence(monster,player));
            }
            return playerBattleService.dead();
            case 3:
                return playerBattleService.runAway();
            default:
                DialogReadService.getDialog("WrondDialog");
                break;
        }
        return 5;
    }

    public int dungeon() {
        DialogReadService.getDialog("DungeonMenuDialog");
        switch (SceneController.scan()) {
            case 1: {
                DialogReadService.getDialog("EnterGoblinDialog");
                playerBattleService.dungeonMaker(new int[] {0,0,1},30);
            }
            break;
            case 2: {
                DialogReadService.getDialog("EnterOrkDialog");
                playerBattleService.dungeonMaker(new int[] {2,2,3},45);
            }
            break;
            case 3: {
                DialogReadService.getDialog("EnterNightElf");
                playerBattleService.dungeonMaker(new int[] {4,4,5,6},60);
            }
            break;
            case 4: {
                DialogReadService.getDialog("EnterSnowMountainDialog");
                playerBattleService.dungeonMaker(new int[] {7},0);
                CharactorDto player = new CharactorDto(playerStatusService.findById(1L));
                player.setMaxHp(80);
                player.setHp(80);
                playerStatusService.update(player);
            }
            break;
            case 5:
                DialogReadService.getDialog("VillageBackGround");
                return 1;
            default:
                DialogReadService.getDialog("WrondDialog");
                break;
        }
        return 6;
    }


}

