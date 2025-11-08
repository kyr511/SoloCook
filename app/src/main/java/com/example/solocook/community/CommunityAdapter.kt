package com.example.solocook.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.R
import com.example.solocook.model.PostUi

/**
 * 커뮤니티 게시글 리스트용 RecyclerView 어댑터
 * - item 클릭 시 onClick 콜백으로 선택된 PostUi를 넘김
 * - submit(list)로 데이터 갱신
 */
class CommunityAdapter(
    private val onClick: (PostUi) -> Unit
) : RecyclerView.Adapter<CommunityAdapter.VH>() {

    private val items = mutableListOf<PostUi>()

    /** 외부에서 새로운 리스트를 세팅할 때 사용 */
    fun submit(list: List<PostUi>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    /** ViewHolder: itemView에서 필요한 뷰들을 findViewById로 잡아둠 */
    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val tvUserName: TextView = view.findViewById(R.id.user_name)
        private val tvTime: TextView = view.findViewById(R.id.time)
        private val tvTitle: TextView = view.findViewById(R.id.title)
        private val tvContent: TextView = view.findViewById(R.id.content)

        init {
            // 아이템 전체 클릭 시 콜백 실행
            view.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    onClick(items[pos])
                }
            }
        }

        /** 한 개 아이템을 화면에 바인딩 */
        fun bind(item: PostUi) {
            tvUserName.text = item.displayName
            tvTime.text = item.timeText
            tvTitle.text = item.title
            tvContent.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.community_rv_item, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}