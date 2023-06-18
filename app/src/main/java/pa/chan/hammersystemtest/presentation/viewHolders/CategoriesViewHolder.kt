package pa.chan.hammersystemtest.presentation.viewHolders


import androidx.recyclerview.widget.RecyclerView
import pa.chan.hammersystemtest.databinding.CategoryItemBinding

class CategoriesViewHolder(
    private val categoryItemBinding: CategoryItemBinding,
    private val onCategoryClick: () -> Unit
) : RecyclerView.ViewHolder(categoryItemBinding.root) {


    fun bind(string: String) {
        categoryItemBinding.categoryCard.setOnClickListener {
            onCategoryClick.invoke()
        }
        categoryItemBinding.categoryName.text = string
    }

}