package uz.lazycoder.playmarketclone.adapters.movies

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.databinding.ItemRvMoviesBinding

class RvMoviesAdapter(private val list: List<String>, private val innerList: List<MovieAndBookM>) :
    RecyclerView.Adapter<RvMoviesAdapter.MoviesForYouVh>() {

    private val innerAdapterItemCount = 10

    inner class MoviesForYouVh(var itemBinding: ItemRvMoviesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(position: Int) {
            itemBinding.apply {
                tvSectionName.text = list[position]

                val startPos = position * innerAdapterItemCount
                val subList = innerList.subList(startPos, startPos + innerAdapterItemCount)

                rvInner.adapter = RvInnerMovieAdapter(subList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesForYouVh {
        return MoviesForYouVh(
            ItemRvMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesForYouVh, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = list.size

}