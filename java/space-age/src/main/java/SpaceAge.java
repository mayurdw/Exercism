class SpaceAge {
    double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        return this.getSeconds() / 31_557_600;
    }

    double onMercury() {
        return this.onEarth() / 0.240_846_700;
    }

    double onVenus() {
        return this.onEarth() / 0.615_197_260;
    }

    double onMars() {
        return this.onEarth() / 1.88_081_580;
    }

    double onJupiter() {
        return this.onEarth() / 11.8_626_150;
    }

    double onSaturn() {
        return this.onEarth() / 29.4_474_980;
    }

    double onUranus() {
        return this.onEarth() / 84.0_168_460;
    }

    double onNeptune() {
        return this.onEarth() / 016_4.79_132;
    }

}
