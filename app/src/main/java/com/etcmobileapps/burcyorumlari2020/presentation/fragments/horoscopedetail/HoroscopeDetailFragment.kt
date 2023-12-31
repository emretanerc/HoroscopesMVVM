package com.etcmobileapps.burcyorumlari2020.presentation.fragments.horoscopedetail

import android.content.res.Configuration
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.etcmobileapps.burcyorumlari2020.R
import com.etcmobileapps.burcyorumlari2020.databinding.HoroscopeDetailFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class HoroscopeDetailFragment : Fragment() {
    private lateinit var binding: HoroscopeDetailFragmentBinding
    private lateinit var viewModel: HoroscopeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = HoroscopeDetailFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HoroscopeDetailViewModel::class.java]

        if (arguments != null) {
            val horroscopeId = HoroscopeDetailFragmentArgs.fromBundle(requireArguments()).id
            Picasso.get().load(HoroscopeDetailFragmentArgs.fromBundle(requireArguments()).image).into(binding.horoscopeIV);

            viewModel.fetchDailyComments(horroscopeId)
            viewModel.fetchWeeklyComments(horroscopeId)
            viewModel.fetchYearlyComments(horroscopeId)


        } else {
            findNavController().navigateUp()
        }


        binding.commentTV.setMovementMethod(ScrollingMovementMethod())

        viewModel.errorState.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                Toast.makeText(requireContext(), resources.getString(R.string.data_problem), Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }

        viewModel.dailyResponse.observe(viewLifecycleOwner, Observer {
            binding.commentTV.text = viewModel.dailyResponse.value?.yorum
            binding.nameTV.text = resources.getString(R.string.horoscope) + viewModel.dailyResponse.value?.burc
            binding.elementTV.text =resources.getString(R.string.element) + viewModel.dailyResponse.value?.element
            binding.mottoTV.text = resources.getString(R.string.motto) + viewModel.dailyResponse.value?.motto
            binding.gezegenTV.text = resources.getString(R.string.planet) + viewModel.dailyResponse.value?.gezegen
        })

        initTablayout()

        return binding.root
    }

    private fun initTablayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        binding.commentTV.text = viewModel.dailyResponse.value?.yorum
                    }

                    1 -> {
                        binding.commentTV.text = viewModel.weeklyResponse.value?.yorum
                    }

                    2 -> {
                        binding.commentTV.text = viewModel.yearlyResponse.value?.yorum
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }
}