package Projekt_BE.GameList;

public class GameManager {
    GameList gameList = new GameList();

    public void createGame(int gameID) {
        Game game = new Game(gameID);
        gameList.addGameToList(game);
    }

    public boolean gameExists(int gameID) {
        return gameList.getGameByGameID(gameID) != null;
    }

    public String[] getGameDecisions(int gameID) {
        Game game = gameList.getGameByGameID(gameID);
        return new String[]{game.getDecision(1), game.getDecision(2)};
    }

    public void addDecisionToPlayerInGame(int gameID, int playerID, String playerDecision) {
        Game game = gameList.getGameByGameID(gameID);
        if (game.getDecision(playerID) == "")
            game.setDecision(playerDecision, playerID);
    }

    public boolean allPlayerDecisionsPresent(int gameID) {
        Game game = gameList.getGameByGameID(gameID);

        if (game.getDecision(1) != ""
                && game.getDecision(2) != "") {
            return true;
        }

        return false;
    }
}

