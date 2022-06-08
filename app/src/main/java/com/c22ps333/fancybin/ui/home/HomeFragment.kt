package com.c22ps333.fancybin.ui.home
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.c22ps333.fancybin.R
import com.c22ps333.fancybin.adapter.FeatureMenuAdapter
import com.c22ps333.fancybin.databinding.FragmentHomeBinding
import com.c22ps333.fancybin.model.FeatureMenu

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var rvFeature: RecyclerView
    private val list = ArrayList<FeatureMenu>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout {
        _binding = FragmentHomeBinding.inflate(LayoutInflater.from(requireActivity()))
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rvFeature = binding!!.cardFeature
        rvFeature.setHasFixedSize(false)
        list.addAll(listFeature)
        showRecyclerList()
    }

    private val listFeature: ArrayList<FeatureMenu>
        get() {
            val dataTitle = resources.getStringArray(R.array.data_title)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataImage = resources.obtainTypedArray(R.array.data_image)
            val listFeature = ArrayList<FeatureMenu>()
            for (i in dataTitle.indices) {
                val feature = FeatureMenu(dataTitle[i], dataDescription[i], dataImage.getResourceId(i, -1))
                listFeature.add(feature)
            }
            return listFeature
        }

    private fun showRecyclerList() {
        binding?.cardFeature?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        val featureMenuAdapter = FeatureMenuAdapter(list)
        rvFeature.adapter = featureMenuAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}