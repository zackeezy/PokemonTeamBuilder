package edu.harding.pokemonteambuilder;

public class Move{
    public Move(String name, Boolean effect, Boolean physical,
                String flavorText, int power, int accuracy){
        mName = name;
        mEffect = effect;
        mPhysical = physical;
        mFlavorText = flavorText;
        mPower = power;
        mAccuracy = accuracy;
    }

    private String mName;
    private Boolean mEffect;
    private Boolean mPhysical;
    private String mFlavorText;
    private int mPower;
    private int mAccuracy;
}
