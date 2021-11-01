public class Lasagna {

    int expectedMinutesInOven(){
        return 40;
    }

    int remainingMinutesInOven( int minsPassed ){
        return this.expectedMinutesInOven() - minsPassed;
    }

    int preparationTimeInMinutes( int layer ) {
        int TIME_PER_LAYER = 2;
        return layer * TIME_PER_LAYER;
    }

    int totalTimeInMinutes( int numberOfLayers, int minsPassed ){
        return this.preparationTimeInMinutes( numberOfLayers )
                + minsPassed;
    }
}
