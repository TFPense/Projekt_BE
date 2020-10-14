package Projekt_BE.GameList;

import java.util.ArrayList;

public class GameList {

    ArrayList<Game> gameList = new ArrayList<Game>();

    public boolean addGameToList(Game game){
        return gameList.add(game);
    }

    public Game getGameByGameID(int gameID){
        for (Game game: gameList) {
            if(game.getGameID() == gameID)
                return game;
        }
        return null;
    }

    public boolean removeGameFromGamelist(int gameId){
        for (Game game:gameList){
            if (game.getGameID()==gameId){
                return gameList.remove(game);
            }

        }
        return false;
    }


}
