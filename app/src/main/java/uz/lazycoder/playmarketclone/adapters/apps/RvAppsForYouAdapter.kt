package uz.lazycoder.playmarketclone.adapters.apps

import android.view.View
import android.graphics.Rect
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.models.TypeM
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.adapters.RvInnerAdapter
import uz.lazycoder.playmarketclone.adapters.RvInnerSmallAdapter
import uz.lazycoder.playmarketclone.models.GameAndAppInnerSmallM
import uz.lazycoder.playmarketclone.databinding.ItemRvAppsForYouBinding
import uz.lazycoder.playmarketclone.databinding.ItemRvAppsForYouAdsBinding

class RvAppsForYouAdapter(private val list: List<TypeM>, private val appsList: List<GameAndAppM>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val typeAds = 2
    private val typeDefault = 1
    private val innerAdapterSpace = 25
    private val innerAdapterItemCount = 10

//    // space item decoration for inner adapter
//    private val itemDecoration = object : RecyclerView.ItemDecoration() {
//        override fun getItemOffsets(
//            outRect: Rect,
//            view: View,
//            parent: RecyclerView,
//            state: RecyclerView.State
//        ) {
//            val childPosition = parent.getChildAdapterPosition(view)
//            if (childPosition == 0) {
//                outRect.left = innerAdapterSpace
//            } else if (childPosition == parent.adapter?.itemCount?.minus(1) ?: 1) {
//                outRect.right = innerAdapterSpace
//            }
//        }
//    }

    // default item
    inner class RvAppsForYouVh(private var itemBinding: ItemRvAppsForYouBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(name: String, position: Int) {
            itemBinding.apply {
                tvSectionName.text = name

                val innerList = ArrayList<GameAndAppInnerSmallM>()
                val startPos = position * innerAdapterItemCount
                val subList = appsList.subList(startPos, startPos + innerAdapterItemCount)
                subList.forEach {
                    val game = GameAndAppInnerSmallM(it.name, it.sizeOrCost, it.icon)
                    innerList.add(game)
                }

//                rvInner.addItemDecoration(itemDecoration)
                rvInner.adapter = RvInnerSmallAdapter(innerList)
            }
        }
    }

    // ads item
    inner class RvAppsForYouAdsVh(private var itemBinding: ItemRvAppsForYouAdsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(name: String, position: Int) {
            itemBinding.apply {
                tvSectionName.text = name

//                rvAppsInnerAds.addItemDecoration(itemDecoration)
                val startPos = position * innerAdapterItemCount
                rvAppsInnerAds.adapter =
                    RvInnerAdapter(appsList.subList(startPos, startPos + innerAdapterItemCount))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == typeDefault) {
            return RvAppsForYouVh(
                ItemRvAppsForYouBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            return RvAppsForYouAdsVh(
                ItemRvAppsForYouAdsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == typeDefault) {
            holder as RvAppsForYouVh
            holder.onBind(list[position].name, position)
        } else {
            holder as RvAppsForYouAdsVh
            holder.onBind(list[position].name, position)
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return if (list[position].type == "def") typeDefault else typeAds
    }

}