package com.timkhakimov.databindingrecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup

import java.util.ArrayList

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Timur Khakimov on 24.03.2019
 */
abstract class BindingItemsAdapter<M> : RecyclerView.Adapter<BindingViewHolder<M>>() {

    protected var list: MutableList<M>

    init {
        list = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<M> {
        val v = LayoutInflater.from(parent.context).inflate(getLayoutRes(viewType), parent, false)
        return BindingViewHolder(v)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<M>, position: Int) {
        val item = getItem(position)
        holder.bind(getVariableId(getItemViewType(position)), item)
    }

    @LayoutRes
    protected abstract fun getLayoutRes(viewType: Int): Int

    protected abstract fun getVariableId(viewType: Int): Int

    override fun getItemCount(): Int {
        return getItems().size
    }

    fun setItems(items: MutableList<M>) {
        this.list = items
        notifyDataSetChanged()
    }

    fun addItems(itemList: List<M>) {
        list.addAll(itemList)
        notifyDataSetChanged()
    }

    fun addItems(position: Int, itemList: MutableList<M>) {
        list.addAll(position, itemList)
        notifyDataSetChanged()
    }

    fun addItem(item: M) {
        list.add(item)
        notifyItemInserted(list.size - 1)
    }

    fun addItem(position: Int, item: M) {
        list.add(position, item)
        notifyItemInserted(position)
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeAll() {
        list.clear()
        notifyDataSetChanged()
    }

    fun getItem(position: Int): M {
        return list[position]
    }

    fun getItems(): MutableList<M> {
        return list
    }
}