package uz.lazycoder.playmarketclone.adapters.games

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.models.TypeM
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.adapters.RvInnerAdapter
import uz.lazycoder.playmarketclone.adapters.RvInnerBigAdapter
import uz.lazycoder.playmarketclone.databinding.ItemRvGamesForYouBinding
import uz.lazycoder.playmarketclone.databinding.ItemRvGamesForYouAdsBinding

class RvGamesForYouAdapter(private val list: List<TypeM>, val gamesList: List<GameAndAppM>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val typeAds = 2
    private val typeDefault = 1
    private val innerAdapterItemCount = 10

    // default item
    inner class RvGamesForYouVh(private var itemBinding: ItemRvGamesForYouBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(name: String, position: Int) {
            itemBinding.apply {
                tvSectionName.text = name
                clSeeAll.setOnClickListener { }

                val startPos = position * innerAdapterItemCount
                rvInner.adapter = RvInnerAdapter(gamesList.subList(startPos, startPos + innerAdapterItemCount))
            }
        }
    }

    // ads item (big item)
    inner class RvGamesForYouAdsVh(private var itemBinding: ItemRvGamesForYouAdsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(name: String, position: Int) {
            itemBinding.apply {
                tvSectionName.text = name

                val startPos = position * innerAdapterItemCount
                rvInnerAds.adapter =
                    RvInnerBigAdapter(gamesList.subList(startPos, startPos + innerAdapterItemCount))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == typeDefault) {
            return RvGamesForYouVh(
                ItemRvGamesForYouBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            return RvGamesForYouAdsVh(
                ItemRvGamesForYouAdsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == typeDefault) {
            holder as RvGamesForYouVh
            holder.onBind(list[position].name, position)
        } else {
            holder as RvGamesForYouAdsVh
            holder.onBind(list[position].name, position)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return if (list[position].type == "def") typeDefault else typeAds
    }

}