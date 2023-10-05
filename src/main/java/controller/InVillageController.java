package controller;

import java.util.*;

import dto.CharactorDto;
import service.DialogReadService;
import service.PlayerStatusService;

public class InVillageController {

    private PlayerStatusService playerStatusService = null;
    private CharactorDto charactorDto = null;
    private WeaponController weaponController = null;

    public InVillageController(){
        playerStatusService = new PlayerStatusService();
        weaponController = new WeaponController();
        charactorDto = new CharactorDto();
    }

    private final DialogReadService dialogReadService = new DialogReadService();


    public void selective(){
        DialogReadService.getDialog("VillageBackGround");
        DialogReadService.getDialog("VillageMenuDialog");
        DialogReadService.getDialog("SelectMenuDialog");

        switch(SceneController.scan()){
            case 1:
                Pub();
                break;
            case 2:
                weaponController.SmithMenu();
                break;
            case 3:
                break;
            default:
                DialogReadService.getDialog("WrondDialog");
        }
    }

    public void Pub(){
        DialogReadService.getDialog("PubBackGround");
        DialogReadService.getDialog("PubMenuDialog");
        DialogReadService.getDialog("SelectMenuDialog");
        CharactorDto player = new CharactorDto(playerStatusService.findById(1L));

        int cGold, cHp;

        switch(SceneController.scan()){
            case 1:
                cGold = -3;
                cHp = 5;
                playerStatusService.GoldChange(player,cGold);
                playerStatusService.HpChange(player,cHp);

                break;
            case 2:
                cGold = -6;
                cHp = 10;
                playerStatusService.GoldChange(player,cGold);
                playerStatusService.HpChange(player,cHp);

                break;
            case 3:
                cGold = -9;
                cHp = 15;
                playerStatusService.GoldChange(player,cGold);
                playerStatusService.HpChange(player,cHp);
                break;
            case 4:
                cGold = -15;
                cHp = 30;
                playerStatusService.GoldChange(player,cGold);
                playerStatusService.HpChange(player,cHp);
                break;
            case 5:
                DialogReadService.getDialog("GoBackTownDialog");
                break;
            default:
                DialogReadService.getDialog("WrondDialog");
        }
    }

}
