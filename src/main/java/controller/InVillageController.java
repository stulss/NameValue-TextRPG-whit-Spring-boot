package controller;

import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;

public class InVillageController {
    private PlayerStatusService playerStatusService;

    public InVillageController(PlayerStatusService playerStatusService){
        this.playerStatusService = playerStatusService;
    }
    public int selective(){
        playerStatusService.printStatus();
        DialogReadService.getDialog("VillageMenuDialog");

        switch(SceneController.scan()){
            case 1:
                DialogReadService.getDialog("PubBackGround");
                return 2;
            case 2:
                DialogReadService.getDialog("SmithBackGround");
                return 3;
            case 3:
                return 4;
            default:
                DialogReadService.getDialog("WrondDialog");
                return 1;
        }
    }
    public int Pub(){
        DialogReadService.getDialog("PubMenuDialog");
        CharactorDto player = new CharactorDto(playerStatusService.findById(1L));

        switch(SceneController.scan()){
            case 1:
                if(playerStatusService.GoldChange(player,-3)){
                    DialogReadService.getDialog("BreadDialog");
                    playerStatusService.HpChange(player,5);
                }
                return 2;
            case 2:
                if(playerStatusService.GoldChange(player,-6)){
                    DialogReadService.getDialog("StewDialog");
                    playerStatusService.HpChange(player,10);
                }
                return 2;
            case 3:
                if(playerStatusService.GoldChange(player,-9)){
                    DialogReadService.getDialog("TurkeyDialog");
                    playerStatusService.HpChange(player,15);
                }
                return 2;
            case 4:
                if(playerStatusService.GoldChange(player,-15)){
                    DialogReadService.getDialog("PubSleep");
                    playerStatusService.HpChange(player,30);
                }
                return 2;
            case 5:
                DialogReadService.getDialog("VillageBackGround");
                return 1;
            default:
                DialogReadService.getDialog("WrondDialog");
                return 2;
        }
    }
}