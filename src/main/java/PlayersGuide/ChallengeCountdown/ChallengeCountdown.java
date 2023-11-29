package PlayersGuide.ChallengeCountdown;

public class ChallengeCountdown {
    public static void main(String[] args){
        challengeCountdown(10);
    }

    private static void challengeCountdown(int x){
        System.out.println(x);
        if(x>1)challengeCountdown(x-1);
    }
}