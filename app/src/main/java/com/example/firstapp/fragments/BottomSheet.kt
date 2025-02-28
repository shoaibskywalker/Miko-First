package com.example.firstapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.adapter.BottomSheetAdapter
import com.example.firstapp.adapter.User
import com.example.firstapp.utils.AppConstant.IMAGE_1
import com.example.firstapp.utils.AppConstant.IMAGE_5
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheet : BottomSheetDialogFragment() {
    private lateinit var challengeAdapter: BottomSheetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler23)
        val recyclerView2: RecyclerView = view.findViewById(R.id.recycler234)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView2.layoutManager = LinearLayoutManager(requireContext())

        val challengeList = mutableListOf(
            User("Shahid Shah", IMAGE_1, R.drawable.indian),
            User("Shoaib Mansuri", IMAGE_5, R.drawable.indian),
        )

        val createdAdapter = BottomSheetAdapter(requireContext(), challengeList, BottomSheetAdapter.TYPE_CREATED)
        recyclerView.adapter = createdAdapter

        val receivedAdapter = BottomSheetAdapter(requireContext(), challengeList, BottomSheetAdapter.TYPE_RECEIVED)
        recyclerView2.adapter = receivedAdapter



        view.findViewById<ImageView>(R.id.exit).setOnClickListener {
            dismiss()
        }

        return view
    }


}