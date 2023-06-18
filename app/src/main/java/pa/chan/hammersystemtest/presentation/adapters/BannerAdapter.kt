package pa.chan.hammersystemtest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.hammersystemtest.databinding.BannerItemBinding
import pa.chan.hammersystemtest.presentation.viewHolders.BannerViewHolder

class BannerAdapter(private val bannerList: List<Int>) :
    RecyclerView.Adapter<BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val itemBinding =
            BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(itemBinding)

    }

    override fun getItemCount(): Int = bannerList.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem = bannerList[position]
        holder.bind(bannerItem)
    }
}