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
        DialogReadService.getDialog("VillageBackGround");
        DialogReadService.getDialog("VillageMenuDialog");
        DialogReadService.getDialog("SelectMenuDialog");

        switch(SceneController.scan()){
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            default:
                DialogReadService.getDialog("WrondDialog");
                return 1;
        }
    }

    public int Pub(){
        DialogReadService.getDialog("PubBackGround");
        DialogReadService.getDialog("PubMenuDialog");
        DialogReadService.getDialog("SelectMenuDialog");

        CharactorDto player = new CharactorDto(playerStatusService.findById(1L));

        switch(SceneController.scan()){
            case 1:
                if(playerStatusService.GoldChange(player,-3)){
                    playerStatusService.HpChange(player,5);
                }
                return 2;
            case 2:
                if(playerStatusService.GoldChange(player,-6)){
                    playerStatusService.HpChange(player,10);
                }
                return 2;
            case 3:
                if(playerStatusService.GoldChange(player,-9)){
                    playerStatusService.HpChange(player,15);
                }
                return 2;
            case 4:
                if(playerStatusService.GoldChange(player,-15)){
                    playerStatusService.HpChange(player,30);
                }
                return 2;
            case 5:
                DialogReadService.getDialog("GoBackTownDialog");
                return 1;
            default:
                DialogReadService.getDialog("WrondDialog");
                return 2;
        }
    }

}
