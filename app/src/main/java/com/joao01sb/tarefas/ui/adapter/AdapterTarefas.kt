package com.joao01sb.tarefas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joao01sb.tarefas.databinding.TaskItemBinding
import com.joao01sb.tarefas.extra.Util.formatDate
import com.joao01sb.tarefas.model.Tarefa

class AdapterTarefas(
    private val tarefas: List<Tarefa> = emptyList(),
    var onItemClickListener: (tarefa: Tarefa) -> Unit = {}
) : RecyclerView.Adapter<AdapterTarefas.ViewHolder>() {

    inner class ViewHolder(
        private val binding: TaskItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun vincularPersonagemComDados(tarefa: Tarefa) {
            binding.nomeTarefa.text = tarefa.titulo
            binding.descricaoDaTarefa.text = tarefa.conteudo
            binding.dataVencimentoDaTarefa.text = tarefa.data.formatDate()
            binding.root.setOnClickListener {
                onItemClickListener(tarefa)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = tarefas[position].let { holder.vincularPersonagemComDados(it) }

    override fun getItemCount(): Int = tarefas.size
}
