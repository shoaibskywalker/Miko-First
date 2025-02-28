package com.example.firstapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.databinding.FriendChallengeBinding

class UserAdapter(
    val context: Context,  private var filteredList: List<User>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val binding = FriendChallengeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = filteredList[position]
        holder.binding.tvName1.text = model.name
        holder.binding.flag.setImageResource(model.flag!!)

        Glide.with(holder.itemView.context)
            .load(model.image)
            .error(R.drawable.emptyprofile)
            .placeholder(R.drawable.emptyprofile)
            .into(holder.binding.profileImage)

        holder.binding.clngBtn.setOnClickListener {
            Toast.makeText(context, "Challenge sent to ${model.name}", Toast.LENGTH_SHORT).show()
        }

    }

    class ViewHolder(val binding: FriendChallengeBinding) : RecyclerView.ViewHolder(binding.root)

    }



