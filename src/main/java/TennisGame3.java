
public class TennisGame3 implements TennisGame {
    
    private int scorePlayer2;
    private int scorePlayer1;
    private final String playerName1;
    private final String playerName2;

    public TennisGame3(String playerName1, String playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
    }

    public String getScore() {
        String score;
        boolean isPlayerScoreEqual=(this.scorePlayer1 == this.scorePlayer2);
        if(isPlayerScoreEqual && scorePlayer1>=3)
            score= "Deuce";
        else
            score= getScoreNotTie(isPlayerScoreEqual);
        return  score;

    }

    private String getScoreNotTie(boolean isPlayerScoreEqual) {
        String score= getScoreMore4();
        if (scorePlayer1 < 4 && scorePlayer2 < 4) {
            score = getScoreLess4(isPlayerScoreEqual);
        }
        return score;
    }

    private String getScoreMore4() {
        String score;
        String player = getPlayerWithMoreScore();
        int player1LessPlayer2=Math.abs(scorePlayer1-scorePlayer2);
        score= getAdvantageOrWin(player,player1LessPlayer2);
        return score;
    }

    private String getAdvantageOrWin(String player,int player1LessPlayer2) {
        return ( player1LessPlayer2== 1) ? "Advantage " + player : "Win for " + player;
    }

    private String getPlayerWithMoreScore() {
        return this.scorePlayer1 > this.scorePlayer2 ? this.playerName1 : this.playerName2;
    }

    private String getScoreLess4(boolean isPlayerScoreEqual) {
        String score;
        String[] listScore = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        score = listScore[scorePlayer1];
        score+= isPlayerScoreEqual ? "-All" :"-" + listScore[scorePlayer2];
        return score;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerName1))
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;
        
    }

}
