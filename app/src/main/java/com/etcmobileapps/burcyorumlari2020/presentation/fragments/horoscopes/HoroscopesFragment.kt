package com.etcmobileapps.burcyorumlari2020.presentation.fragments.horoscopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.etcmobileapps.burcyorumlari2020.databinding.HoroscopesFragmentBinding
import com.etcmobileapps.burcyorumlari2020.presentation.fragments.horoscopes.adapter.HoroscopesAdapter

class HoroscopesFragment : Fragment() {
    private lateinit var binding: HoroscopesFragmentBinding
    private lateinit var viewModel: HoroscopesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = HoroscopesFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HoroscopesViewModel::class.java]

        viewModel.initHoroscopes()
        viewModel.horoscopeList.observe(viewLifecycleOwner, Observer { it ->
            binding.horoscopesRV.adapter = HoroscopesAdapter(it) {
                val action = HoroscopesFragmentDirections.actionHoroscopesFragmentToHoroscopeDetailFragment(it.horospopeId, it.horoscopeImage)
                findNavController().navigate(action)
            }
            binding.horoscopesRV.layoutManager = GridLayoutManager(requireActivity().applicationContext, 3)
        })

        return binding.root
    }
}