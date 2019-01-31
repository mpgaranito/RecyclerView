package br.com.garanito.recyclerview.recyclerview.ui

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.garanito.recyclerview.recyclerview.R
import br.com.garanito.recyclerview.recyclerview.api.getPicassoAuth
import br.com.garanito.recyclerview.recyclerview.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_row.view.*

class ListaPokemonAdapter(
        private val context : Context,
        private  val pokemons : List<Pokemon>
        ) :

        RecyclerView.Adapter<ListaPokemonAdapter.PokemonViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.pokemon_row,parent,false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindView(pokemons[position])
    }

    class  PokemonViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView){
        fun bindView(pokemon:Pokemon) = with(itemView){
            tvPokemon.text = pokemon.nome
            getPicassoAuth(itemView.context)
                    .load("https://pokedexdx.herokuapp.com${pokemon.imagem}")
                    .into(ivPokemon)
        }
    }
}