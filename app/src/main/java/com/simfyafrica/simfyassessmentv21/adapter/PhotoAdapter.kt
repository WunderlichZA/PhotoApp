package com.simfyafrica.simfyassessmentv21.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.simfyafrica.simfyassessmentv21.model.Photo
import com.simfyafrica.simfyassessmentv21.R
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class PhotoAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var photos = emptyList<Photo>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhotoViewHolder(itemView)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val current = photos[position]
        Glide.with(holder.itemView.context)
            .load(current.url)
            .into(holder.photoImageView)
    }

    internal fun setPhotos(photoList : List<Photo>) {
        this.photos = photoList
        notifyDataSetChanged()
    }



    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.cat_photo
    }
}