public class TennisGame2 implements TennisGame
{
    private int pointPlayer1  = 0;
    private int pointPlayer2  = 0;

    private final String playerName1;
    private final String playerName2;


    public TennisGame2(String player1Name, String player2Name) {
        this.playerName1 = player1Name;
        this.playerName2 = player2Name;
    }

    public String getScore(){
        String[] listaScore={"Love","Fifteen","Thirty","Forty",""};
        String score = "";
        score = getScoreTie(listaScore);

        score = getScoreFrom0to3(score,listaScore);
        if(pointPlayer1>=4 || pointPlayer2>=4)
            score = getScoreMorethan3(score);
        return score;
    }

    private String getScoreMorethan3(String score) {
        int isPlayer1MorePlayer2=this.pointPlayer1-pointPlayer2;
        score = getScoreAdvantege(score,isPlayer1MorePlayer2);
        score = getScoreWin(score,isPlayer1MorePlayer2);

        return score;
    }

    private String getScoreWin(String score,int isPlayer1MorePlayer2) {

        if (isPlayer1MorePlayer2>=2)
        {
            score = "Win for player1";
        }
        if (isPlayer1MorePlayer2<=-2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreAdvantege(String score,int isPlayer1MorePlayer2) {
        if (isPlayer1MorePlayer2==1)
        {
            score = "Advantage player1";
        }

        if (isPlayer1MorePlayer2==-1)
        {
            score = "Advantage player2";
        }
        return score;
    }

    private String getScoreFrom0to3(String score,String[] listaScore) {
        if(pointPlayer1<4 && pointPlayer1!=pointPlayer2) {
            String resPlayer1 = listaScore[pointPlayer1];
            String resPlayer2 = listaScore[pointPlayer2];
            score= resPlayer1 + "-" + resPlayer2;
        }
        return score;
    }

    private String getScoreTie(String[] listaScore) {
       String score="Deuce";
        if (pointPlayer1  == pointPlayer2 && pointPlayer1<3) {
            score = listaScore[pointPlayer1];
            score += "-All";
        }
        return score;
    }

    public void scorePlayer1(){
        pointPlayer1 ++;
    }

    public void scorePlayer2(){
        pointPlayer2 ++;
    }

    public void wonPoint(String player) {
        if (player.equals(this.playerName1))
            scorePlayer1();
        if (player.equals(this.playerName2))
            scorePlayer2();
    }
}