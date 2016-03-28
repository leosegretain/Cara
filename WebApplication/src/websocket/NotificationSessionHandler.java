package websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Léo on 28/03/2016.
 */
@ApplicationScoped
@ServerEndpoint("/Notif/{contratId}")
public class NotificationSessionHandler {

    private static HashMap<Integer, Session> sessions = new HashMap<>();

    public static void sendNotification(int contratId) {

        try {
            Session s = sessions.get(contratId);

            if (s != null) {
                s.getBasicRemote().sendText("Votre contrat vient d'être cloturé par votre courtier");
            }
        } catch (IOException e) {
        }
    }

    @OnOpen
    public void openConnection(Session session,
                               EndpointConfig c,
                               @PathParam("contratId") int contratId) {
        sessions.put(contratId, session);
    }

    @OnClose
    public void closedConnection(Session session) {

        for (Map.Entry<Integer, Session> entry : sessions.entrySet()) {

            if (entry.getValue().equals(session))
                sessions.remove(entry.getKey());
        }
    }

    @OnError
    public void error(Session session, Throwable t) {

        for (Map.Entry<Integer, Session> entry : sessions.entrySet()) {

            if (entry.getValue().equals(session))
                sessions.remove(entry.getKey());
        }
    }
}
