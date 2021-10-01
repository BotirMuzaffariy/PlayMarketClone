package uz.lazycoder.playmarketclone.adapters

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.utils.loadImage
import uz.lazycoder.playmarketclone.models.GameAndAppInnerSmallM
import uz.lazycoder.playmarketclone.databinding.ItemRvInnerSmallBinding

class RvInnerSmallAdapter(private val list: List<GameAndAppInnerSmallM>) :
    RecyclerView.Adapter<RvInnerSmallAdapter.SmallInnerVh>() {

    inner class SmallInnerVh(var itemBinding: ItemRvInnerSmallBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(gameAndAppM: GameAndAppInnerSmallM) {
            itemBinding.apply {
                tvName.text = gameAndAppM.name
                tvSize.text = gameAndAppM.sizeOrCost

                ivIcon.loadImage(gameAndAppM.icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallInnerVh {
        return SmallInnerVh(
            ItemRvInnerSmallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SmallInnerVh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}