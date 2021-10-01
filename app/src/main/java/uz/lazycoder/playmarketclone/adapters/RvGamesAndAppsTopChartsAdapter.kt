package uz.lazycoder.playmarketclone.adapters

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.utils.loadImage
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.databinding.ItemRvGamesAndAppsTopChartBinding

class RvGamesAndAppsTopChartsAdapter(private val list: List<GameAndAppM>) :
    RecyclerView.Adapter<RvGamesAndAppsTopChartsAdapter.RvGamesTopChartsVh>() {

    inner class RvGamesTopChartsVh(var itemBinding: ItemRvGamesAndAppsTopChartBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(gameAndAppM: GameAndAppM, position: Int) {
            itemBinding.apply {
                tvName.text = gameAndAppM.name
                tvRate.text = gameAndAppM.rate
                tvSize.text = gameAndAppM.sizeOrCost
                tvCategory.text = gameAndAppM.category
                tvPosition.text = position.toString()

                ivIcon.loadImage(gameAndAppM.icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvGamesTopChartsVh {
        return RvGamesTopChartsVh(
            ItemRvGamesAndAppsTopChartBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RvGamesTopChartsVh, position: Int) {
        holder.onBind(list[position], position + 1)
    }

    override fun getItemCount() = list.size

}