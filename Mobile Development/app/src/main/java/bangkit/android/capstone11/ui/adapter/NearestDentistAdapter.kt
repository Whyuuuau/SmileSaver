package bangkit.android.capstone11.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.data_local.NearestDentist

class NearestDentistAdapter(private val listNearestDentist: ArrayList<NearestDentist>): RecyclerView.Adapter<NearestDentistAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_dentist)
        val tvName: TextView = itemView.findViewById(R.id.tv_dentist_name)
        val tvAddress: TextView = itemView.findViewById(R.id.tv_dentist_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_dentist_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listNearestDentist.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (image, name, address) = listNearestDentist[position]
        holder.image.setImageResource(image)
        holder.tvName.text = name
        holder.tvAddress.text = address
    }

}