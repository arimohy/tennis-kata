import java.io.Console;

public class TennisGame2 implements TennisGame
{
    private int pointPlayer1 = 0;
    private int pointPlayer2 = 0;

    private String resPlayer1 = "";
    private String resPlayer2 = "";

    private final String playerName1;
    private final String playerName2;


    public TennisGame2(String player1Name, String player2Name) {
        this.playerName1 = player1Name;
        this.playerName2 = player2Name;
    }

    public String getScore(){
        String score = "";
        score = getScoreTie();
        score = getScoreFrom0to3(score);
        int valor=pointPlayer1-pointPlayer2;
        score = getScoreGreaterthan4(score,valor);
        return score;
    }

    private String getScoreGreaterthan4(String score,int valor) {
        score = getScoreAdvange(score);
        if(pointPlayer1>=4 || pointPlayer2>=4)
            score = getScoreWin(score,valor);
        return score;
    }

    private String getScoreWin(String score,int valor) {
        if (valor>=2)
        {
            score = "Win for player1";
        }
        if (valor<=-2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreAdvange(String score) {
        if (pointPlayer1 > pointPlayer2 && pointPlayer2 >= 3)
        {
            score = "Advantage player1";
        }

        if (pointPlayer2 > pointPlayer1 && pointPlayer1 >= 3)
        {
            score = "Advantage player2";
        }
        return score;
    }

    private String getScoreFrom0to3(String score) {
        String[] listaScore={"Love","Fifteen","Thirty","Forty",""};
        if(pointPlayer2==0 ||pointPlayer1==0)
            score = getScorewith0(score, listaScore);


        score = getScoreLessThan4(score, listaScore);

        return score;
    }

    private String getScoreLessThan4(String score, String[] listaScore) {

        if (pointPlayer1>pointPlayer2 && pointPlayer1 < 4)
        {
            resPlayer1=listaScore[pointPlayer1];
            resPlayer2=listaScore[pointPlayer2];
            score = resPlayer1 + "-" + resPlayer2;
        }
        if(pointPlayer2>pointPlayer1 && pointPlayer2 < 4)
        {
            resPlayer2=listaScore[pointPlayer2];
            resPlayer1=listaScore[pointPlayer1];
            score = resPlayer1 + "-" + resPlayer2;
        }
        return score;
    }

    private String getScorewith0(String score, String[] listaScore) {
        if (pointPlayer1 > 0 )
        {
            resPlayer1=listaScore[pointPlayer1];
            resPlayer2 = "Love";
            score = resPlayer1 + "-" + resPlayer2;
        }
        if (pointPlayer2 > 0 )
        {
            resPlayer2 =listaScore[pointPlayer2];

            resPlayer1 = "Love";
            score = resPlayer1 + "-" + resPlayer2;
        }
        return score;
    }

    private String getScoreTie() {
        String[] listaScore={"Love","Fifteen","Thirty"};
        String score="Deuce";
        if (pointPlayer1 == pointPlayer2 && pointPlayer1 <=2)
        {
            score = listaScore[pointPlayer1];
            score += "-All";
        }
        return score;
    }

    public void setScorePlayer1(int number){

        for (int i = 0; i < number; i++)
        {
            addScorePlayer1();
        }
            
    }
    
    public void setScorePlayer2(int number){
        
        for (int i = 0; i < number; i++)
        {
            addScorePlayer2();
        }
            
    }
    
    public void addScorePlayer1(){
        pointPlayer1++;
    }
    
    public void addScorePlayer2(){pointPlayer2++;}


    public void wonPoint(String player) {
        if (player.equals(this.playerName1))
            addScorePlayer1();
        if(player.equals(this.playerName2))
            addScorePlayer2();
    }
}