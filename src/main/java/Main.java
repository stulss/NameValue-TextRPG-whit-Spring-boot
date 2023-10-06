import controller.SceneController;
import service.DialogReadService;

public class Main {
    public static void main(String[] args) {
        SceneController sceneController = new SceneController();
        DialogReadService.getDialog("TitleDialog");
        if(SceneController.scan()==1) {
            sceneController.sceneSelect();
        }
        System.exit(0);
    }
}