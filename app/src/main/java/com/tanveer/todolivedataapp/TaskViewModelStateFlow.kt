package com.tanveer.todolivedataapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TaskViewModelStateFlow :ViewModel(){
    private val _taskList  = MutableStateFlow<List<TaskStateFlow>>(emptyList())
    val taskList: StateFlow<List<TaskStateFlow>> = _taskList
     private var nextId = 1

    //function to add task
    fun addTask(name: String){
        val task = TaskStateFlow(nextId++, name)
        _taskList.update { it + task }
    }
 //function to remove task
    fun removeTask(task: TaskStateFlow){
        _taskList.update { it.filterNot { it.id == task.id}}
        }

}


