package com.android.a2mvcdandagger.screens.questionslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.questions.Question
import com.android.a2mvcdandagger.screens.common.viewmvc.BaseViewMvc
import com.google.android.material.floatingactionbutton.FloatingActionButton

class QuestionsListViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
): BaseViewMvc<QuestionsListViewMvc.Listener>(
    layoutInflater,
    parent,
    R.layout.activity_questions_list
) {

    interface Listener {
        fun onRefreshClicked()
        fun onQuestionClicked(clickQuestion: Question)
        fun onToViewModelActivity()
    }

    private val swipeRefresh: SwipeRefreshLayout
    private val recyclerView: RecyclerView
    private val questionsAdapter: QuestionsAdapter
    private val fbViewModel:FloatingActionButton

    init {

        swipeRefresh = findViewById(R.id.swipeRefresh)
        fbViewModel = findViewById(R.id.fbViewModel)
        swipeRefresh.setOnRefreshListener {

            for (listener in listeners) {
                listener.onRefreshClicked()
            }
        }

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        questionsAdapter = QuestionsAdapter { clickQuestion ->

            for (listener in listeners) {
                listener.onQuestionClicked(clickQuestion)
            }
        }
        recyclerView.adapter = questionsAdapter

        fbViewModel.setOnClickListener {
            for (listener in listeners){
                listener.onToViewModelActivity()
            }
        }
    }

    fun bindQuestions(questions: List<Question>) {
        questionsAdapter.bindData(questions)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }

    class QuestionsAdapter(
        private val onQuestionClickListener: (Question) -> Unit
    ) : RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>() {


        private var questionList: List<Question> = ArrayList(0)

        inner class QuestionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.txt_title)
        }

        fun bindData(questions: List<Question>) {
            questionList = ArrayList(questions)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_question_list_item, parent, false)
            return QuestionsViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
            holder.title.text = questionList[position].title
            holder.itemView.setOnClickListener {
                onQuestionClickListener.invoke(questionList[position])
            }
        }

        override fun getItemCount(): Int {
            return questionList.size
        }
    }

}