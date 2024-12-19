package com.codegalaxy.paginationexample.view.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codegalaxy.paginationexample.databinding.FragmentListBinding
import com.codegalaxy.paginationexample.view.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.fragment.app.viewModels

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentListBinding
    private val adapter = ProductAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.products.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        adapter.addLoadStateListener { loadState ->
            binding.progressBar.isVisible = loadState.source.refresh is androidx.paging.LoadState.Loading

            val errorState = loadState.source.refresh as? androidx.paging.LoadState.Error
            errorState?.let {
                Toast.makeText(requireContext(), "Error: ${it.error.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
