package uz.lazycoder.playmarketclone.adapters

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.models.GameAndAppInnerSmallM
import uz.lazycoder.playmarketclone.databinding.ItemRvGamesAndAppsKidsBinding

class RvGamesAndAppsKidsAdapter(private val list: List<String>, private val innerList: List<GameAndAppInnerSmallM>) :
    RecyclerView.Adapter<RvGamesAndAppsKidsAdapter.GamesKidsVh>() {

    private val innerAdapterItemCount = 10

    inner class GamesKidsVh(var itemBinding: ItemRvGamesAndAppsKidsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(position: Int) {
            itemBinding.apply {
                tvSectionName.text = list[position]

                val startPos = position * innerAdapterItemCount
                rvInner.adapter = RvInnerSmallAdapter(innerList.subList(startPos, startPos + innerAdapterItemCount))
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GamesKidsVh {
        return GamesKidsVh(
            ItemRvGamesAndAppsKidsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GamesKidsVh, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = list.size

}