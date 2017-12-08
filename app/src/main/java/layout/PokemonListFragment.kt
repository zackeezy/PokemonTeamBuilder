package layout

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import edu.harding.pokemonteambuilder.*
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import java.util.ArrayList
import kotlinx.android.synthetic.main.list_item_pokemon.*
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.onUiThread
import org.jetbrains.anko.support.v4.toast
import java.io.Serializable


class PokemonListFragment() : Fragment() {

    private lateinit var mView: View

    var mContext: Context? = null
    var mProgress: ProgressBar? = null
    constructor(context: Context) : this() {
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        fillRecycler()
        return mView
    }


    private fun fillRecycler() {
        var db = PokemonDatabase(this.activity.getPreferences(MODE_PRIVATE))
        var api = PokemonFetcher()

        var recyclerView: RecyclerView = mView.findViewById(R.id.pokemon_list_recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Separator between list items
        var separator = DividerItemDecoration(recyclerView.context, 1)
        recyclerView.addItemDecoration(separator)

//<<<<<<< HEAD
//        try {
//            var adapter = PokemonAdapter(db.load())
//            recyclerView.adapter = adapter
//        } catch (e: Exception) {
//            Log.d("RECYCLER", e.toString())
//            alert("Please update your database") {
//                title = "DB Error"
//                okButton { }
//            }.show()
//=======
        var list = resources.getStringArray(R.array.pokedex).toList()
        var adapter = PokemonAdapter(list as ArrayList)
        recyclerView.adapter = adapter
        /*doAsync {
            uiThread {

                progressBar.visibility = View.GONE
            }
        }*/
    }

    // For RecyclerView
    private inner class PokemonHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_pokemon, parent, false)),
            View.OnClickListener {

        private lateinit var mPokemon: CustomPokemon
        private val mNameLabel: TextView

        init {
            itemView.setOnClickListener(this)

            mNameLabel = itemView.findViewById(R.id.pokemon_name_textview) as TextView
        }


        fun bind(p: String) {
            mNameLabel.text = p
            mNameLabel.textColor = Color.WHITE
        }


        override fun onClick(view: View?) {
            /*var name = pokemon_name_textview.text.toString()
            //var type = pokemon_type_textview.text.split("/")
            var pokemon = CustomPokemon(name, "")*/
            var name = view?.findViewById<TextView>(R.id.pokemon_name_textview)?.text
            var i = Intent()
            i.putExtra("Pokemon", name)
            activity.setResult(0,i)
            activity.finish()
        }
    }

    // For RecyclerView
    private inner class PokemonAdapter(private val mPokemonList: ArrayList<String>) :
            RecyclerView.Adapter<PokemonHolder>() {

        override fun getItemCount(): Int = mPokemonList.count()


        override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): PokemonHolder {
            val layoutInflater = LayoutInflater.from(activity)

            return PokemonHolder(layoutInflater, parent)
        }


        override fun onBindViewHolder(holder: PokemonHolder, index: Int) {
            val p = mPokemonList.get(index)
            holder.bind(p)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var pla = activity as PokemonListActivity
        var pokemon = pla.intent.extras["Pokemon"] as CustomPokemon
        var i = Intent()
        i.putExtra("Pokemon",pokemon as Serializable)
        i.putExtra("pokemon",pla.intent.extras["pokemon"] as Int)
        pla.setResult(0,i)
        pla.finish()
        super.onActivityResult(requestCode, resultCode, data)
    }

}
