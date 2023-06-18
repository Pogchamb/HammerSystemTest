package pa.chan.hammersystemtest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.hammersystemtest.databinding.CategoryItemBinding
import pa.chan.hammersystemtest.presentation.viewHolders.CategoriesViewHolder


class CategoriesAdapter(private val categoriesList: List<String>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    var onCategoryClick: (() -> Unit) = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemBinding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(itemBinding, onCategoryClick)

    }

    override fun getItemCount(): Int = categoriesList.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categoryItem = categoriesList[position]

        holder.bind(categoryItem)


    }
}