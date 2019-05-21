import java.util.Arrays;

class Yacht {
    private int[] dice;
    private YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {

        this.dice = dice;
        Arrays.sort(this.dice);
        this.yachtCategory = yachtCategory;
    }

    private int getSum(){
        int Sum = 0;

        for( int i : this.dice){
            Sum += i;
        }

        return Sum;
    }

    private int getMatches( int MatchTo ){
        int Count = 0;

        for( int i : this.dice ){
            if( i == MatchTo ){
                Count++;
            }
        }

        return Count;
    }

    private int getMatches( ){
        int MaxMatch = 0;
        int Count = 0;


        for( int i = 0; i < this.dice.length - 1; i++ ){
            if( this.dice[i] == this.dice[i+1] ){
                Count++;
            }
            else{
                Count = 0;
            }

            if( MaxMatch < Count + 1 ){
                MaxMatch = Count + 1;
            }
        }

        return MaxMatch;
    }
    int score() {
        int Score = 0;

        switch (this.yachtCategory){
            case YACHT:
                Score = ( this.getMatches( ) == 5 ) ? 50 : 0;
                break;
            case ONES:
                Score = this.getMatches(1);
                break;
            case TWOS:
                Score = 2 * this.getMatches(2);
                break;
            case FOURS:
                Score = 4 * this.getMatches(4);
                break;
            case THREES:
                Score = 3 * this.getMatches(3);
                break;
            case FIVES:
                Score = 5 * this.getMatches(5);
                break;
            case SIXES:
                Score = 6 * this.getMatches(6);
                break;
            case FULL_HOUSE:{
                // Three of one kind, two of the other
                int OneKind = getMatches();
                if( OneKind == 3 || OneKind == 2 ){
                    int OtherKind = getMatches( this.dice[this.dice.length - 1] );
                    if( OtherKind == 2 || OtherKind == 3 ){
                        Score = this.getSum();
                    }
                }
            }
            break;
            case FOUR_OF_A_KIND:{
                if( this.getMatches() >= 4 ){
                    int Number = ( this.getMatches(this.dice[0] ) == 4 ) ? this.dice[0] : this.dice[this.dice.length - 1];
                    Score = 4 * Number;
                }
            }
            break;
            case LITTLE_STRAIGHT:{
                if( Arrays.equals(this.dice, new int[]{1,2,3,4,5})){
                    Score = 30;
                }
            }
            case BIG_STRAIGHT:{
                if( Arrays.equals(this.dice,new int[]{2,3,4,5,6})){
                    Score = 30;
                }
            }
            break;
            case CHOICE:
                Score = this.getSum();
                break;
        }

        return Score;
    }

}
