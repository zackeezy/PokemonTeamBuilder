package edu.harding.pokemonteambuilder;

import android.graphics.Bitmap;
import android.util.Pair;

import java.util.List;

public class Pokemon {

    private Bitmap mThumbnail;
    private String mName;
    private String mType;
    List<Move> mLearnedMoves;
    List<Pair<String, String>> mAbilities;

    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.mThumbnail = thumbnail;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

}
