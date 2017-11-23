package edu.harding.pokemonteambuilder;

public class Move{
    public Move(String name, String flavorText, int accuracy){
        mName = name;
        mEffect = true;
        mPhysical = null;
        mFlavorText = flavorText;
        mPower = 0;
        mAccuracy = accuracy;
    }

    public Move(String name, Boolean physical, String flavorText, int power, int accuracy){
        mName = name;
        mEffect = false;
        mPhysical = physical;
        mFlavorText = flavorText;
        mPower = power;
        mAccuracy = accuracy;
    }

    public Move(String name, String flavorText, int accuracy, int learnLevel){
        mName = name;
        mEffect = true;
        mPhysical = null;
        mFlavorText = flavorText;
        mPower = 0;
        mAccuracy = accuracy;
        mLearnLevel = learnLevel;
    }

    public Move(String name, Boolean physical, String flavorText,
                int power, int accuracy, int learnLevel){
        mName = name;
        mEffect = false;
        mPhysical = physical;
        mFlavorText = flavorText;
        mPower = power;
        mAccuracy = accuracy;
        mLearnLevel = learnLevel;
    }

    private String mName;
    private Boolean mEffect;
    private Boolean mPhysical;
    private String mFlavorText;
    private int mPower;
    private int mAccuracy;
    private int mLearnLevel;

    public Boolean getEffect() {
        return mEffect;
    }

    public void setEffect(Boolean effect) {
        this.mEffect = effect;
    }

    public Boolean getPhysical() {
        return mPhysical;
    }

    public void setPhysical(Boolean physical) {
        this.mPhysical = physical;
    }

    public String getFlavorText() {
        return mFlavorText;
    }

    public void setFlavorText(String flavorText) {
        this.mFlavorText = flavorText;
    }

    public int getPower() {
        return mPower;
    }

    public void setPower(int power) {
        this.mPower = power;
    }

    public int getAccuracy() {
        return mAccuracy;
    }

    public void setAccuracy(int accuracy) {
        this.mAccuracy = accuracy;
    }

    public int getLearnLevel() {
        return mLearnLevel;
    }

    public void setLearnLevel(int learnLevel) {
        this.mLearnLevel = learnLevel;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }


}
