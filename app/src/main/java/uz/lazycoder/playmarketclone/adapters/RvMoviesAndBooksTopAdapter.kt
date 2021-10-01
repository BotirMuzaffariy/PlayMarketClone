package uz.lazycoder.playmarketclone.adapters

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.utils.loadImage
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.databinding.ItemRvMoviesAndBooksTopBinding

class RvMoviesAndBooksTopAdapter(private val list: List<MovieAndBookM>) :
    RecyclerView.Adapter<RvMoviesAndBooksTopAdapter.MoviesAndBooksTopVh>() {

    inner class MoviesAndBooksTopVh(var itemBinding: ItemRvMoviesAndBooksTopBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(movieAndBookM: MovieAndBookM, position: Int) {
            itemBinding.apply {
                tvName.text = movieAndBookM.name
                tvRate.text = movieAndBookM.rate
                tvCost.text = movieAndBookM.cost
                tvPosition.text = position.toString()
                tvCategory.text = movieAndBookM.category

                ivImage.loadImage(movieAndBookM.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAndBooksTopVh {
        return MoviesAndBooksTopVh(
            ItemRvMoviesAndBooksTopBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesAndBooksTopVh, position: Int) {
        holder.onBind(list[position], position + 1)
    }

    override fun getItemCount() = list.size

}