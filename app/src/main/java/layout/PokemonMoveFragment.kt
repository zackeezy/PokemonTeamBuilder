package layout

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import edu.harding.pokemonteambuilder.*

import kotlinx.android.synthetic.main.list_item_pokemon.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.textColor
import org.jetbrains.anko.uiThread
import java.util.*

class PokemonMoveFragment() : Fragment() {

    private lateinit var mView: View

    var mContext: Context? = null

    constructor(context: Context) : this() {
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_pokemon_move, container, false)

        fillRecycler()
        return mView
    }


    private fun fillRecycler() {
        val api = PokemonFetcher()
        val converter = PokemonConverter()

        var recyclerView: RecyclerView = mView.findViewById(R.id.pokemon_list_recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Separator between list items
        var separator = DividerItemDecoration(recyclerView.context, 1)
        recyclerView.addItemDecoration(separator)

        doAsync {
            var adapter = PokemonAdapter(api.getPokemon())
            uiThread { recyclerView.adapter = adapter }
        }
    }

    // For RecyclerView
    private inner class PokemonHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_pokemon, parent, false)),
            View.OnClickListener {

        private lateinit var mPokemon: CustomPokemon
        private val mNameLabel: TextView
        private val mTypeLabel: TextView

        init {
            itemView.setOnClickListener(this)

            mNameLabel = itemView.findViewById(R.id.pokemon_name_textview) as TextView
            mTypeLabel = itemView.findViewById(R.id.pokemon_type_textview) as TextView
        }


        fun bind(p: CustomPokemon) {
            var typeString: String

            mPokemon = p;
            mNameLabel.text = p.name
            mNameLabel.textColor = Color.WHITE

            if (p.types.size == 2)
                typeString = p.types[0] + "/" + p.types[1]
            else
                typeString = p.types[0]

            mTypeLabel.text = typeString
            mTypeLabel.textColor = Color.WHITE
        }


        override fun onClick(view: View?) {
            var name = pokemon_name_textview.text.toString()
            var type = pokemon_type_textview.text.split("/")
            var pokemon = CustomPokemon(name, type as ArrayList<String>)
            var i = Intent(mContext, PokemonSetupActivity::class.java)
            startActivityForResult(i,0)
        }
    }

    // For RecyclerView
    private inner class PokemonAdapter(private val mPokemonList: ArrayList<CustomPokemon>) :
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
}// Required empty public constructor