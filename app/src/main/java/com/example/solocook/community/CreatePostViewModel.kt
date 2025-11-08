// community/CreatePostViewModel.kt
package com.example.solocook.community

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.solocook.model.PostUi
import com.example.solocook.repository.CommunityRepository
import kotlinx.coroutines.launch

class CreatePostViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = CommunityRepository(application.applicationContext)

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _created = MutableLiveData<PostUi?>()
    val created: LiveData<PostUi?> = _created

    fun submit(title: String, content: String) {
        if (_loading.value == true) return
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val result = repo.createPost(title, content)
                _created.value = result
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to create post."
            } finally {
                _loading.value = false
            }
        }
    }

    fun clearError() { _error.value = null }
}
