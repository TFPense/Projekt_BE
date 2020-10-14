package Projekt_BE.web;


import Projekt_BE.GameList.GameManager;
import Projekt_BE.SchereSteinPapier;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SchereSteinPapierEndpoint extends AbstractHandler {

    private final SchereSteinPapier schereSteinPapier;
    private final GameManager gameManager;

    public SchereSteinPapierEndpoint(SchereSteinPapier schereSteinPapier, GameManager gameManager){

        this.schereSteinPapier = schereSteinPapier;
        this.gameManager = gameManager;

    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int gameID = 0;
        int playerID = 0;
        String playerDecision = "";

        String decisionPlayerOne = "";
        String decisionPlayerTwo = "";
        String gameResolution = "";

        if(request.getParameter("gameID") != null)
            gameID = Integer.parseInt(request.getParameter("gameID"));
        if(request.getParameter("playerID") != null)
            playerID = Integer.parseInt(request.getParameter("playerID"));
        if(request.getParameter("playerDecision") != null)
            playerDecision = request.getParameter("playerDecision");

        if(gameID != 0 && !gameManager.gameExists(gameID)){
            gameManager.createGame(gameID);
        }

        if (    gameID != 0
                && gameManager.gameExists(gameID) &&
                playerID != 0 &&
                playerDecision != ""){
            gameManager.addDecisionToPlayerInGame(gameID, playerID, playerDecision);
        }
        else{
            throw new IOException("GameManager data request failed");
        }

        if(gameManager.allPlayerDecisionsPresent(gameID)){
            String[] gamePlayerDecisions = gameManager.getGameDecisions(gameID);
            decisionPlayerOne = gamePlayerDecisions[0];
            decisionPlayerTwo = gamePlayerDecisions[1];

            gameResolution = schereSteinPapier.compareDecisions(decisionPlayerOne, decisionPlayerTwo);
        }

        JSONObject gameData = new JSONObject();
        gameData.put("winner", gameResolution);
        gameData.put("playerOne", decisionPlayerOne);
        gameData.put("playerTwo", decisionPlayerTwo);

        response.getWriter().print(gameData);

        baseRequest.setHandled(true);
    }


    }

