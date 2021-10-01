package uz.lazycoder.playmarketclone.adapters.movies

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.utils.loadImage
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.databinding.ItemRvInnerMoviesBinding

class RvInnerMovieAdapter(private val list: List<MovieAndBookM>) :
    RecyclerView.Adapter<RvInnerMovieAdapter.MovieInnerVh>() {

    inner class MovieInnerVh(var itemBinding: ItemRvInnerMoviesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(movieAndBookM: MovieAndBookM) {
            itemBinding.apply {
                tvName.text = movieAndBookM.name
                tvCost.text = movieAndBookM.cost

                ivImage.loadImage(movieAndBookM.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInnerVh {
        return MovieInnerVh(
            ItemRvInnerMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInnerVh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}