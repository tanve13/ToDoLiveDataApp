package com.tanveer.todolivedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
    private val _taskList = MutableLiveData<List<Task>>(emptyList())
    val taskList : LiveData<List<Task>> = _taskList
    private var taskIdCounter = 0

    fun addTask(title:String){
     val updatedList = _taskList.value.orEmpty().toMutableList()
     updatedList.add(Task(id = taskIdCounter++,title = title))
        _taskList.value = updatedList

    }
    fun deleteTask(task:Task){
        val updatedList =_taskList.value.orEmpty().toMutableList()
        updatedList.remove(task)
        _taskList.value = updatedList


    }




}