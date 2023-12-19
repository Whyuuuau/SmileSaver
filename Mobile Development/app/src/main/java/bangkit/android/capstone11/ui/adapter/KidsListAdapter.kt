package bangkit.android.capstone11.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.data_local.DummyKidsData

class KidsListAdapter(private val kidsList: DummyKidsData): RecyclerView.Adapter<KidsListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_avatar)
        val tvName: TextView = itemView.findViewById(R.id.tv_kids_data_name)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kids_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val context = holder.itemView.context
        val female = context.getString(R.string.female)

        if (kidsList.gender == female) {
            holder.image.setImageResource(R.drawable.ic_girl)
        } else {
            holder.image.setImageResource(R.drawable.ic_boy)
        }

        holder.tvName.text = kidsList.name
    }

    override fun getItemCount(): Int = 1

}