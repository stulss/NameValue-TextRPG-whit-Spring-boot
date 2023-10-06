package controller;

import service.DialogReadService;
import service.PlayerBattleService;
import service.PlayerStatusService;
import service.WeaponService;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SceneController {
    private BattleController battleController = null;
    private GameController gameController = null;
    private InVillageController inVillageController = null;
    private PlayerStatusService playerStatusService = null;
    private PlayerBattleService playerBattleService = null;
    private WeaponService weaponService = null;
    private WeaponController weaponController = null;

    public SceneController(){
        playerStatusService = new PlayerStatusService();
        playerBattleService = new PlayerBattleService(playerStatusService);
        weaponService = new WeaponService(playerStatusService);
        inVillageController = new InVillageController(playerStatusService);
        battleController = new BattleController(playerStatusService,playerBattleService);
        gameController = new GameController(playerStatusService);
        weaponController = new WeaponController(playerStatusService,weaponService);
        Initialize();
    }

    private static Scanner scanner;

    public static void Initialize(){scanner = new Scanner(System.in);}

    public static int scan() {
        int num = 0;

        try {
            DialogReadService.getDialog("SelectMenuDialog");

            num = scanner.nextInt();
            scanner.nextLine();
            try{
                TimeUnit.SECONDS.sleep(1);}
            catch (InterruptedException e) {
                DialogReadService.getDialog("ErrorDelayDialog");
            }
        } catch (NoSuchElementException e) {
            scanner.nextLine();
            DialogReadService.getDialog("WrongDialog");
        }
        return num;
    }

    public static String scanName() {
        String name = null;

        try {
            DialogReadService.getDialog("InputName");

            name = scanner.nextLine();
        } catch (NoSuchElementException e) {
            DialogReadService.getDialog("WrongDialog");
        }
        return name;
    }

    public void sceneSelect(){
        int choice = 1;
        gameController.GameStory();
        while (true){
            switch (choice){
                case 1:
                    choice = inVillageController.selective();
                    break;
                case 2:
                    choice = inVillageController.Pub();
                    break;
                case 3:
                    choice = weaponController.SmithMenu();
                    break;
                case 4:
                    choice = battleController.dungeon();
                    break;
                case 5:
                    choice = battleController.war();
                    break;
                case 6:
                    choice = playerBattleService.nextMonster();
                default:
                    break;
            }
        }
    }
}
