import controller.SceneController;
import service.DialogReadService;

public class Main {
    DialogReadService dialogReadService = new DialogReadService();
    //GameController gameController = new GameController(playerStatusService);
    public static void main(String[] args) {
        DialogReadService dialogReadService = new DialogReadService();
        SceneController sceneController = new SceneController();
        DialogReadService.getDialog("TitleDialog");
        if(SceneController.scan()==1) {
            sceneController.sceneSelect();
        }
        System.exit(0);
    }
}