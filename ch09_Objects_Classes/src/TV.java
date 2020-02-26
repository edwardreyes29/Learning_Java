public class TV {
    int channel = 1;    // Default channel is 1
    int volumeLevel = 1;    // Default volume is 1
    boolean on = false;     // TV is off

    public TV() {

    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void setChannel(int channel) {
        if(on && channel >= 1 && channel <= 120)
            this.channel = channel;
    }

    public void setVolume(int volumeLevel) {
        if (on && volumeLevel >= 1 && volumeLevel <= 7)
            this.volumeLevel = volumeLevel;
    }

    public void channelUp() {
        if (on && channel < 120)
            channel++;
    }

    public void channelDown() {
        if (on && channel > 1)
            channel--;
    }

    public void volumeUp() {
        if (on && channel < 7)
            volumeLevel++;
    }

    public void volumeDown() {
        if (on && volumeLevel > 1)
            volumeLevel--;
    }


}
