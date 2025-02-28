package com.example.firstapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.adapter.User
import com.example.firstapp.adapter.UserAdapter
import com.example.firstapp.databinding.FragmentFirstBinding
import com.example.firstapp.utils.AppConstant.CHESS
import com.example.firstapp.utils.AppConstant.CHESS2
import com.example.firstapp.utils.AppConstant.CHESSCOM
import com.example.firstapp.utils.AppConstant.IMAGE_1
import com.example.firstapp.utils.AppConstant.IMAGE_2
import com.example.firstapp.utils.AppConstant.IMAGE_3
import com.example.firstapp.utils.AppConstant.IMAGE_4
import com.example.firstapp.utils.AppConstant.IMAGE_5
import com.example.firstapp.utils.AppConstant.LICHESS
import com.example.firstapp.utils.AppConstant.ME
import com.example.firstapp.utils.AppConstant.MIKO_CHESS
import com.example.firstapp.utils.AppConstant.PERSON
import com.example.firstapp.utils.AppConstant.SQUAREOFF

class First : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var mAdapter: UserAdapter
    private val challengeList = mutableListOf<User>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var isFirstSelection = true

        Glide.with(requireContext())
            .load(CHESS)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active.first)
        Glide.with(requireContext())
            .load(CHESS2)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active.second)

        Glide.with(requireContext())
            .load(CHESS)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active2.first)
        Glide.with(requireContext())
            .load(CHESS2)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active2.second)

        Glide.with(requireContext())
            .load(PERSON)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active.image)
        Glide.with(requireContext())
            .load(PERSON)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active2.image)

        Glide.with(requireContext())
            .load(ME)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active.image2)
        Glide.with(requireContext())
            .load(ME)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.active2.image2)



        val userList = mutableListOf(
            User(
                name = "Shahid Shah",
                image = IMAGE_1,
                flag = R.drawable.indian
            ),
            User(
                name = "Shoaib Mansuri",
                image = IMAGE_2,
                flag = R.drawable.indian
            ),
            User(
                name = "Shahid Shah",
                image = IMAGE_3,
                flag = R.drawable.indian
            ),
            User(
                name = "Krishna Dubey",
                image = IMAGE_4,
                flag = R.drawable.indian
            ),
            User(
                name = "Sakib Shaikh",
                image = IMAGE_5,
                flag = R.drawable.indian
            ),
        )


        val bottomSheet = BottomSheet()
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        mAdapter = UserAdapter(requireContext(), userList)
        binding.recycler.adapter = mAdapter


        val items = listOf("Chess.com", "Miko Chess", "Lichess", "SquareOff")
        val adapter = ArrayAdapter(requireContext(), R.layout.custom_spinner, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        binding.bigSpin.mySpinner.adapter = adapter
        Glide.with(requireContext())
            .load(CHESSCOM)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(binding.bigSpin.spinnerIcon)
        binding.bigSpin.button.setOnClickListener {
            Toast.makeText(requireContext(), "Selected:", Toast.LENGTH_SHORT).show()
        }


        binding.bigSpin.mySpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (isFirstSelection) {
                        isFirstSelection = false // Ignore the first call
                        return
                    }
                    when (position) {
                        0 -> Glide.with(requireContext())
                            .load(CHESSCOM)
                            .error(R.drawable.emptyprofile)
                            .placeholder(R.drawable.emptyprofile)
                            .into(binding.bigSpin.spinnerIcon)

                        1 -> Glide.with(requireContext())
                            .load(MIKO_CHESS)
                            .error(R.drawable.emptyprofile)
                            .placeholder(R.drawable.emptyprofile)
                            .into(binding.bigSpin.spinnerIcon)

                        2 -> Glide.with(requireContext())
                            .load(LICHESS)
                            .error(R.drawable.emptyprofile)
                            .placeholder(R.drawable.emptyprofile)
                            .into(binding.bigSpin.spinnerIcon)

                        3 -> Glide.with(requireContext())
                            .load(SQUAREOFF)
                            .error(R.drawable.emptyprofile)
                            .placeholder(R.drawable.emptyprofile)
                            .into(binding.bigSpin.spinnerIcon)
                    }
                    val selectedItem = parent.getItemAtPosition(position).toString()
                    Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Optional: Handle case where nothing is selected
                }
            }


        binding.viewall.setOnClickListener{
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}