package uz.lazycoder.playmarketclone.adapters

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.databinding.ItemRvCategoriesBinding

class RvCategoriesAdapter(private val list: List<String>) :
    RecyclerView.Adapter<RvCategoriesAdapter.CategoriesVh>() {

    inner class CategoriesVh(var itemBinding: ItemRvCategoriesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(name: String) {
            itemBinding.tvName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesVh {
        return CategoriesVh(
            ItemRvCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesVh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}