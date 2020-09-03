package com.assem.gadsleaderboard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.assem.gadsleaderboard.R
import com.assem.gadsleaderboard.ui.home.adapters.LeaderBoardAdapter
import com.assem.gadsleaderboard.utils.Constants
import com.assem.gadsleaderboard.utils.Constants.Companion.FILTER_KEY
import com.assem.gadsleaderboard.utils.Constants.Companion.TYPE_KEY
import com.assem.gadsleaderboard.utils.Resource
import kotlinx.android.synthetic.main.fragment_leader_board.view.*

class LeaderBoardFragment : Fragment() {

    // views
    private lateinit var recyclerView: RecyclerView

    // vars
    private lateinit var leaderBoardAdapter: LeaderBoardAdapter
    private lateinit var viewModel: LeaderBoardViewModel
    private var isHoursFlag = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_leader_board, container, false)
        viewModel = ViewModelProvider(this).get(LeaderBoardViewModel::class.java)
        if (arguments != null) {
            viewModel.filterBoardMutableLiveData.value = arguments!!.getString(FILTER_KEY)!!
            isHoursFlag = arguments!!.getBoolean(TYPE_KEY)
        }
        leaderBoardAdapter = LeaderBoardAdapter(isHoursFlag)
        recyclerView = view.fragment_leader_board_recycler_View
        recyclerView.apply {
            adapter = leaderBoardAdapter
        }
        getLeaderBoard()
        return view
    }


    private fun getLeaderBoard() {
        viewModel.getLeaderBoard()
        viewModel.leaderBoardMutableLiveData.observe(this, { response ->
            when (response) {
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    response.data?.let { response ->
                        leaderBoardAdapter.differ.submitList(response)
                    }
                    Toast.makeText(
                        requireContext(),
                        "Success => ${response.data!!.size}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is Resource.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "Error => ${response.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    println("Assem => ${response.message}")
                }
            }
        })
    }
}