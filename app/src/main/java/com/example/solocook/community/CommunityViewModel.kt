package com.example.solocook.community

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solocook.repository.CommunityRepository
import com.example.solocook.model.PostUi
import kotlinx.coroutines.launch

class CommunityViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = CommunityRepository(application.applicationContext)

    // 목록
    private val _posts = MutableLiveData<List<PostUi>>()
    val posts: LiveData<List<PostUi>> = _posts

    // 상세(선택된 게시글)
    private val _selected = MutableLiveData<PostUi?>()
    val selected: LiveData<PostUi?> = _selected

    // 로딩/에러 상태 (필요 시 UI에서 observe)
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    /** 커뮤니티 목록 불러오기 */
    fun loadList() {
        if (_loading.value == true) return
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val list = repo.getPosts()
                _posts.value = list
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load posts."
            } finally {
                _loading.value = false
            }
        }
    }

    /** 상세 불러오기 (post_id 기준) */
    fun loadDetail(id: String) {
        if (_loading.value == true) return
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val detail = repo.getPostDetail(id)
                _selected.value = detail
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load detail."
            } finally {
                _loading.value = false
            }
        }
    }

    /** 목록에서 이미 가진 아이템을 선택했을 때(네트워크 호출 없이 세팅) */
    fun select(item: PostUi) {
        _selected.value = item
    }

    /** 에러 메시지 한번 소비 후 초기화하고 싶을 때 */
    fun clearError() { _error.value = null }
}
