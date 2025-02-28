package com.example.firstapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.databinding.CreatedChallengeLayoutBinding
import com.example.firstapp.utils.AppConstant.CHESSCOM
import com.example.firstapp.utils.AppConstant.IMAGE_4
import com.example.firstapp.utils.AppConstant.IMAGE_5
import com.example.firstapp.utils.AppConstant.LICHESS
import com.example.firstapp.utils.AppConstant.ME


class BottomSheetAdapter(
    val context: Context,  private val challengeList: List<User>, private val viewType: Int
) : RecyclerView.Adapter<BottomSheetAdapter.ChallengeViewHolder>() {

    companion object {
        const val TYPE_CREATED = 1
        const val TYPE_RECEIVED = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ChallengeViewHolder {
        val binding = CreatedChallengeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChallengeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        val model = challengeList[position]
        holder.binding.name1.text = model.name
        holder.binding.flag.setImageResource(model.flag!!)
        when (viewType) {
            TYPE_CREATED -> {
                Glide.with(holder.itemView.context)
                    .load(IMAGE_4)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.imagepic)
                Glide.with(holder.itemView.context)
                    .load(ME)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.image2)

                Glide.with(holder.itemView.context)
                    .load(CHESSCOM)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.first)

                Glide.with(holder.itemView.context)
                    .load(LICHESS)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.second)

                holder.binding.date.visibility = View.GONE
                holder.binding.buttonAccept.visibility = View.GONE
                holder.binding.buttonDecline.visibility = View.GONE
                holder.binding.autoDelete.visibility = View.VISIBLE
                holder.binding.button.visibility = View.VISIBLE

            }
            TYPE_RECEIVED -> {
                Glide.with(holder.itemView.context)
                    .load(IMAGE_5)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.imagepic)
                Glide.with(holder.itemView.context)
                    .load(ME)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.image2)

                Glide.with(holder.itemView.context)
                    .load(CHESSCOM)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.first)

                Glide.with(holder.itemView.context)
                    .load(LICHESS)
                    .error(R.drawable.emptyprofile)
                    .placeholder(R.drawable.emptyprofile)
                    .into(holder.binding.second)

                holder.binding.date.visibility = View.VISIBLE
                holder.binding.buttonAccept.visibility = View.VISIBLE
                holder.binding.buttonDecline.visibility = View.VISIBLE
                holder.binding.autoDelete.visibility = View.GONE
                holder.binding.button.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return challengeList.size
    }



    class ChallengeViewHolder(val binding: CreatedChallengeLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}