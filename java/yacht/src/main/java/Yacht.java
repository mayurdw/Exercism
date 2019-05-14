import java.util.Arrays;
import java.util.List;

class Yacht {
    private int[] dice;
    private YachtCategory yachtCategory;
    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        Arrays.sort(this.dice);
        this.yachtCategory = yachtCategory;
    }

    int getMatches(){
        return 0;
    }

    int score() {
        int Score = 0;
        int MaxMatch = 0;
        int Count = 0;

        for( int i = 0; i < this.dice.length - 1; i++ ){
            if( this.dice[i] == this.dice[i+1]){
                Count++;
            }
            else{
                MaxMatch = Count + 1;
                Count = 0;
            }
        }

        MaxMatch = Count + 1;
        switch (MaxMatch){
            case 5: {
                if (this.yachtCategory == YachtCategory.YACHT) {
                    Score = 50;
                } else {
                    Score = 0;
                }
                break;
            }

            default:
                break;
        }

        return Score;
    }

}
