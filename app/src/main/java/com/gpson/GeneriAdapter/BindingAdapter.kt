package com.gpson.GeneriAdapter

import androidx.recyclerview.widget.RecyclerView
import com.gpson.modal.jsonModalClass


object BindingAdapter {

    @androidx.databinding.BindingAdapter("setAdapter", requireAll = false)
    @JvmStatic
    fun setRecyclerview(view:RecyclerView?,adapter: GenericAdapter<jsonModalClass.Pet>?){
        view?.adapter = adapter
    }

}