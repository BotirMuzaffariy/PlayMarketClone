package uz.lazycoder.playmarketclone.adapters.books

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.databinding.ItemRvBooksForYouBinding

class RvBooksForYouAdapter(private val list: List<String>, val innerList: List<MovieAndBookM>) :
    RecyclerView.Adapter<RvBooksForYouAdapter.BooksForYouVh>() {

    private val innerAdapterItemCount = 10

    inner class BooksForYouVh(var itemBinding: ItemRvBooksForYouBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(position: Int) {
            itemBinding.apply {
                tvSectionName.text = list[position]

                val startPos = position * innerAdapterItemCount
                val subList = innerList.subList(startPos, startPos + innerAdapterItemCount)

                rvInner.adapter = RvInnerBooksAdapter(subList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksForYouVh {
        return BooksForYouVh(
            ItemRvBooksForYouBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksForYouVh, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = list.size

}