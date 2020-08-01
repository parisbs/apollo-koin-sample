package com.example.apollokoin.main

import com.example.apollokoin.R
import com.example.apollokoin.entities.Post
import com.example.apollokoin.graphql.GetPostQuery
import com.example.apollokoin.ui.Adapter
import com.example.apollokoin.ui.ViewHolder
import kotlinx.android.synthetic.main.item_post.view.*

class MainAdapter(
    private val onClick: (Post) -> (Unit)
) : Adapter<Post>() {

    override fun bind(item: Post, viewHolder: ViewHolder) {
        viewHolder.itemView.postTitle.apply {
            text = item.title
        }
        viewHolder.itemView.postAuthor.apply {
            text = context.getString(
                R.string.post__author,
                item.user?.name ?: context.getString(R.string.unknown)
            )
        }
        viewHolder.itemView.postLastUpdate.apply {
            text = context.getString(
                R.string.post__last_update,
                item.updatedAt
            )
        }
        viewHolder.itemView.apply {
            setOnClickListener { onClick(item) }
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_post
}