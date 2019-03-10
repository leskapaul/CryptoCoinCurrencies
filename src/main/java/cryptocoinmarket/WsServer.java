package cryptocoinmarket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketendpoint")
public class WsServer {


    @OnOpen
    public void onOpen(){
        System.out.println("Open Connection...");
    }

    @OnClose
    public void onClose() {
        System.out.println("Close Connection...");
    }

    @OnMessage
    public String onMessage(String message){
        System.out.print("Message from the clinet: " + message);
        String echoMsg = "Echo from the server: " + message;
        return echoMsg;
    }

    @OnError
    public void onError(Throwable e){
        e.printStackTrace();
    }
}
