package edu.harding.pokemonteambuilder

import android.content.SharedPreferences
import com.google.gson.Gson
import java.util.*

/**
 * Created by Bryan Cuneo on 12/06/17.
 */
class PokemonDatabase(prefs: SharedPreferences) {

    private val DB_NAME: String = "PokemonDB"
    private var mPrefs: SharedPreferences
    private var mGson: Gson
    private var mEditor: SharedPreferences.Editor

    init {
        mPrefs = prefs
        mGson = Gson()
        mEditor = prefs.edit()
    }

    fun save(dbList: ArrayList<CustomPokemon>) {
        var json = mGson.toJson(dbList)
        mEditor.putString(DB_NAME, json)
        mEditor.commit()
    }

    fun load() : ArrayList<CustomPokemon> {
        var json = mPrefs.getString(DB_NAME, "")
        return mGson.fromJson(json, ArrayList<CustomPokemon>().javaClass)
    }
}