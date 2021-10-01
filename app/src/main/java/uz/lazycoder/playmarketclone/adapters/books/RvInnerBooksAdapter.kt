package uz.lazycoder.playmarketclone.adapters.books

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.utils.loadImage
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.databinding.ItemRvInnerBooksBinding

class RvInnerBooksAdapter(val list: List<MovieAndBookM>) :
    RecyclerView.Adapter<RvInnerBooksAdapter.BooksInnerVh>() {

    inner class BooksInnerVh(var itemBinding: ItemRvInnerBooksBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(movieAndBookM: MovieAndBookM) {
            itemBinding.apply {
                tvName.text = movieAndBookM.name
                tvRate.text = movieAndBookM.rate
                tvCost.text = movieAndBookM.cost

                ivImage.loadImage(movieAndBookM.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksInnerVh {
        return BooksInnerVh(
            ItemRvInnerBooksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksInnerVh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}