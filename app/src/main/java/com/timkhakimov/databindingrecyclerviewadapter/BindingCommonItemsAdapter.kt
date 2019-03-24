package com.timkhakimov.databindingrecyclerviewadapter

import androidx.annotation.LayoutRes

/**
 * Created by Timur Khakimov on 24.03.2019
 */
class BindingCommonItemsAdapter<M>(@field:LayoutRes val layoutResId: Int, val variableId: Int) : BindingItemsAdapter<M>() {

    override fun getLayoutRes(viewType: Int): Int {
        return layoutResId
    }

    override fun getVariableId(viewType: Int): Int {
        return variableId
    }
}
