
public class TennisGame2 implements TennisGame
{
    private int pointPlayer1 = 0;
    private int pointPlayer2 = 0;

    
    private String P1res = "";
    private String P2res = "";
    private String playerName1;
    private String playerName2;


    public TennisGame2(String player1Name, String player2Name) {
        this.playerName1 = player1Name;
        this.playerName2 = player2Name;
    }

    public String getScore(){
        String score = "";
        if (pointPlayer1 == pointPlayer2 && pointPlayer1 < 4)
        {
            if (pointPlayer1==0)
                score = "Love";
            if (pointPlayer1==1)
                score = "Fifteen";
            if (pointPlayer1==2)
                score = "Thirty";
            score += "-All";
        }
        if (pointPlayer1==pointPlayer2 && pointPlayer1>=3)
            score = "Deuce";
        
        if (pointPlayer1 > 0 && pointPlayer2==0)
        {
            if (pointPlayer1==1)
                P1res = "Fifteen";
            if (pointPlayer1==2)
                P1res = "Thirty";
            if (pointPlayer1==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (pointPlayer2 > 0 && pointPlayer1==0)
        {
            if (pointPlayer2==1)
                P2res = "Fifteen";
            if (pointPlayer2==2)
                P2res = "Thirty";
            if (pointPlayer2==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (pointPlayer1>pointPlayer2 && pointPlayer1 < 4)
        {
            if (pointPlayer1==2)
                P1res="Thirty";
            if (pointPlayer1==3)
                P1res="Forty";
            if (pointPlayer2==1)
                P2res="Fifteen";
            if (pointPlayer2==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (pointPlayer2>pointPlayer1 && pointPlayer2 < 4)
        {
            if (pointPlayer2==2)
                P2res="Thirty";
            if (pointPlayer2==3)
                P2res="Forty";
            if (pointPlayer1==1)
                P1res="Fifteen";
            if (pointPlayer1==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (pointPlayer1 > pointPlayer2 && pointPlayer2 >= 3)
        {
            score = "Advantage player1";
        }
        
        if (pointPlayer2 > pointPlayer1 && pointPlayer1 >= 3)
        {
            score = "Advantage player2";
        }
        
        if (pointPlayer1>=4 && pointPlayer2>=0 && (pointPlayer1-pointPlayer2)>=2)
        {
            score = "Win for player1";
        }
        if (pointPlayer2>=4 && pointPlayer1>=0 && (pointPlayer2-pointPlayer1)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addScorePlayer1();
        }
            
    }
    
    public void SetP2Score(int number){
        
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