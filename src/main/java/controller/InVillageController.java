package controller;

import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;

public class InVillageController {
    private PlayerStatusService playerStatusService;
    DialogReadService dialogReadService = new DialogReadService();
    public InVillageController(PlayerStatusService playerStatusService){
        this.playerStatusService = playerStatusService;
    }
    public int selective(){
        dialogReadService.villageBackGround();
        dialogReadService.villageMenuDialog();
        dialogReadService.selectMenuDialog();

        switch(SceneController.scan()){
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            default:
                dialogReadService.wrongDialog();
                return 1;
        }
    }
    public int Pub(){
        dialogReadService.pubBackGround();
        dialogReadService.pubMenuDialog();
        dialogReadService.selectMenuDialog();

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
                System.out.println("마을로 돌아갑니다");
                return 1;
            default:
                dialogReadService.wrongDialog();
                return 2;
        }
    }
}