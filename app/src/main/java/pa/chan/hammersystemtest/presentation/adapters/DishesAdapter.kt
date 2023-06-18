package pa.chan.hammersystemtest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.hammersystemtest.databinding.DishInfoItemBinding
import pa.chan.hammersystemtest.domain.model.DishModel
import pa.chan.hammersystemtest.presentation.viewHolders.DishesViewHolder

class DishesAdapter(private val dishesList: List<DishModel>) :
    RecyclerView.Adapter<DishesViewHolder>() {

    override fun getItemCount(): Int = dishesList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val itemBinding =
            DishInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DishesViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        val dishItem = dishesList[position]
        holder.bind(dishItem)
    }
}