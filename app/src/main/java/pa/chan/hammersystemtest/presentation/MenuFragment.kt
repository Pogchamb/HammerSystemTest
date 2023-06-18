package pa.chan.hammersystemtest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.hammersystemtest.R
import pa.chan.hammersystemtest.databinding.MenuFrarmentBinding
import pa.chan.hammersystemtest.presentation.adapters.BannerAdapter
import pa.chan.hammersystemtest.presentation.adapters.CategoriesAdapter
import pa.chan.hammersystemtest.presentation.adapters.DishesAdapter

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private var _binding: MenuFrarmentBinding? = null
    private val binding get() = _binding

    private val viewModel: DishesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MenuFrarmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bannerRecyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val bannerList = listOf(R.drawable.banner, R.drawable.banner)
        binding?.bannerRecyclerView?.adapter = BannerAdapter(bannerList)
        binding?.categoryRecyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding?.dishesRecyclerView?.layoutManager = LinearLayoutManager(requireContext())

        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            binding?.categoryRecyclerView?.adapter = CategoriesAdapter(it.toList()).apply {
                this.onCategoryClick = {}
            }
        }

        viewModel.dishesLiveData.observe(viewLifecycleOwner) {
            binding?.dishesRecyclerView?.adapter = DishesAdapter(it)
        }

        val spinner: Spinner = view.findViewById(R.id.countrySpinner)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.forSpinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        viewModel.fetchDishes()


    }

}