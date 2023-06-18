package pa.chan.hammersystemtest.presentation.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pa.chan.hammersystemtest.databinding.DishInfoItemBinding
import pa.chan.hammersystemtest.domain.model.DishModel

class DishesViewHolder(
    private val dishInfoItemBinding: DishInfoItemBinding
) : RecyclerView.ViewHolder(dishInfoItemBinding.root) {

    fun bind(dishModel: DishModel) {
        with(dishInfoItemBinding) {
            this.dishName.text = dishModel.name
            this.dishDescription.text = dishModel.description
            this.inCartBtn.text = dishModel.price.toString() + " р"
            Glide.with(dishInfoItemBinding.root).load(dishModel.imageUrl).into(this.dishImage)
        }


    }
}