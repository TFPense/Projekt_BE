package Projekt_BE.web;


import Projekt_BE.GameList.GameManager;
import Projekt_BE.SchereSteinPapier;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class WebServer {

    private final SchereSteinPapier schereSteinPapier;
    private final GameManager gameManager;
    private final CorsHandler corsHandler;

    public WebServer(SchereSteinPapier ssp, GameManager gameManager, CorsHandler corsHandler) {

        this.schereSteinPapier = ssp;
        this.gameManager = gameManager;
        this.corsHandler = corsHandler;


    }
    public void startServer() throws Exception{

        final ContextHandler ssp = new ContextHandler("/ssp");
        ssp.setAllowNullPathInfo(true);
        ssp.setHandler(new SchereSteinPapierEndpoint(schereSteinPapier, gameManager, corsHandler));

        ContextHandlerCollection handlerCollection= new ContextHandlerCollection(ssp);

        String port = System.getenv("PORT");

        if (port==null){
            port="8080";
        }

        final Server server = new Server(Integer.parseInt(port));

        server.setHandler(handlerCollection);
        server.start();
        server.join();
    }

}
