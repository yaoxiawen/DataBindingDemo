package com.example.databindingdemo

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingdemo.databinding.DataBindingFragmentBinding
import com.example.databindingdemo.databinding.ItemRvBinding

class DataBindingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //fragment中通过DataBinding加载布局
        val dataBinding: DataBindingFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.data_binding_fragment, container, false)
        //数据
        val list = ArrayList<ItemModel>()
        list.add(ItemModel("first item"))
        list.add(ItemModel("second item"))
        list.add(ItemModel("third item"))
        dataBinding.rv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ItemAdapter(context, list)
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    val position: Int = parent.getChildLayoutPosition(view)
                    if (position != 0) {
                        outRect.top = 30
                    }
                }
            })
        }
        return dataBinding.root
    }

    private inner class ItemAdapter(var context: Context, var list: List<ItemModel>) :
        RecyclerView.Adapter<ItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val dataBinding: ItemRvBinding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(context),
                    R.layout.item_rv,
                    parent,
                    false
                )
            return ItemViewHolder(dataBinding)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val binding = holder.binding
            binding.model = list[position]
        }

        override fun getItemCount(): Int = list.size

    }

    private inner class ItemViewHolder(var binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root)

}