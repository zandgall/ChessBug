package chessBug.misc;

import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;




public class SendFriendRequestUI {
    private VBox page = new VBox();
    IFriendRequestController controller;
    
    public SendFriendRequestUI(IFriendRequestController controller){
        this.controller = controller;
        
        buildClosedRequestField();
    }
    public VBox getPage(){return page;}
    
    private void buildClosedRequestField(){
        Button newFriend = new Button("Add Friend");
        newFriend.setOnAction(event -> buildFriendRequest());
        page.getChildren().add(newFriend);
    }
    private void buildFriendRequest(){
        page.getChildren().clear();
        //Create UI Layout
        TextField input = new TextField();
        Button btnSearch = new Button("Send");
        page.getChildren().addAll(new Label("Search by Username:"), input, btnSearch);
        
        //Add functionality
        input.setOnAction(event -> sendFriendRequest(input.getText()));
        btnSearch.setOnAction(event -> sendFriendRequest(input.getText()));
    }
    private void sendFriendRequest(String friendUsername){
        if (!friendUsername.isEmpty()){
            page.getChildren().clear();
        
            boolean isRequestSent = controller.sendFriendRequest(friendUsername);
            String msg = (isRequestSent)? "Request sent" : "Error: Request not sent";
            page.getChildren().add(new Label(msg));

            buildClosedRequestField();
        }
    }
    
}
