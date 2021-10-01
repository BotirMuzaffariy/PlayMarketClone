package uz.lazycoder.playmarketclone.adapters

import android.view.ViewGroup
import kotlin.text.StringBuilder
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.utils.loadImage
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.databinding.ItemRvInnerBigBinding

class RvInnerBigAdapter(private val list: List<GameAndAppM>) :
    RecyclerView.Adapter<RvInnerBigAdapter.InnerBigVh>() {

    inner class InnerBigVh(var itemBinding: ItemRvInnerBigBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(gameAndAppM: GameAndAppM) {
            itemBinding.apply {
                val tagsBuilder = StringBuilder()
                for (tag in gameAndAppM.tags) {
                    tagsBuilder.append(" •").append(" $tag")
                }

                tvName.text = gameAndAppM.name
                tvRate.text = gameAndAppM.rate
                tvSize.text = gameAndAppM.sizeOrCost
                tvCategory.text = gameAndAppM.category
                tvTags.text = tagsBuilder.toString()

                ivIcon.loadImage(gameAndAppM.icon)
                ivScreenshot.loadImage(gameAndAppM.screenshot)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerBigVh {
        return InnerBigVh(
            ItemRvInnerBigBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InnerBigVh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}