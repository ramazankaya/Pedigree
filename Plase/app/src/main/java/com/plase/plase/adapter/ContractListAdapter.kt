package com.plase.plase.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.plase.plase.R
import com.plase.plase.databinding.RowContractItemBinding
import com.plase.plase.model.api.entry.Contacts

class ContractListAdapter(private val dataSet: ArrayList<Contacts>) :
    RecyclerView.Adapter<ContractListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(binding: RowContractItemBinding) : RecyclerView.ViewHolder(binding.root) {

             var bindings: RowContractItemBinding

        init {
            bindings = binding
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        var binding:  RowContractItemBinding
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        binding = RowContractItemBinding.inflate(layoutInflater);

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bindings.data = dataSet[position]!!
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}