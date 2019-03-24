package com.timkhakimov.databindingrecyclerviewadapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

import android.view.View

/**
 * Created by Timur Khakimov on 24.03.2019
 */
class BindingViewHolder<M>(view: View) : RecyclerView.ViewHolder(view) {

    protected var binding: ViewDataBinding? = null

    init {
        binding = DataBindingUtil.bind(view)
    }

    fun bind(variableId: Int, model: M) {
        binding!!.setVariable(variableId, model)
        binding!!.executePendingBindings()
    }
}
