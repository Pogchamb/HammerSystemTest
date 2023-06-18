package pa.chan.hammersystemtest.presentation.viewHolders

import androidx.recyclerview.widget.RecyclerView
import pa.chan.hammersystemtest.databinding.BannerItemBinding

class BannerViewHolder(
    private val bannerItemBinding: BannerItemBinding
) : RecyclerView.ViewHolder(bannerItemBinding.root) {

    fun bind(res: Int) {
        bannerItemBinding.banner.setBackgroundResource(res)
    }

}