
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String playerName1;
    private final String playerName2;

    public TennisGame1(String player1Name, String player2Name) {
        this.playerName1 = player1Name;
        this.playerName2 = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.playerName1))
            scorePlayer1 += 1;
        if (playerName.equals(this.playerName2))
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score;
        boolean isEqualScore=scorePlayer1 == scorePlayer2;
        if (isEqualScore)
            score = getScoreTie();
        else
            score=getScoreNotTie();
        return score;
    }
    private String getScoreNotTie(){
        String score="";
        if((scorePlayer1 >= 4) || (scorePlayer2 >= 4) )
            score = getScoreGreaterthan4();
        else
            score = getScoreFrom0to3();
        return score;
    }

    private String getScoreGreaterthan4() {
        String score="Win for ";
        int minusResult = scorePlayer1 - scorePlayer2;
        if(Math.abs(minusResult)==1)
            score="Advantage ";
        return score+elegirJugador(minusResult);
    }
    private String elegirJugador(int minusResult){
        String nombre=this.playerName2;
        if(minusResult>0)
            nombre= this.playerName1;
        return nombre;
    }
    private String getScoreFrom0to3() {
        return getScoreFrom0to3ForPlayer(this.scorePlayer1)+"-"+getScoreFrom0to3ForPlayer(this.scorePlayer2);
    }
    private String getScoreFrom0to3ForPlayer(int score){
        String[] listaScore={"Love","Fifteen","Thirty","Forty"};
        return listaScore[score];
    }

    private String getScoreTie() {
        String[] listaScore={"Love-All","Fifteen-All","Thirty-All","Deuce"};
        int score= Math.min(this.scorePlayer1, 3);
        return listaScore[score];
    }
}
