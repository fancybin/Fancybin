package com.c22ps333.fancybin.ui.home
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.c22ps333.fancybin.R
import com.c22ps333.fancybin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout? {
        _binding = FragmentHomeBinding.inflate(LayoutInflater.from(requireActivity()))
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.cardFeature?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}