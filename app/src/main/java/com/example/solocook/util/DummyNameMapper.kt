package com.example.solocook.util


import android.content.Context
import kotlin.math.abs

object DummyNameMapper {
    private const val PREF = "dummy_name_map"
    private const val KEY_PREFIX = "author_"

    private val adjectives = listOf("노래하는","요리하는","웃는","빠른","도전하는","신나는","행복한","차분한","엉뚱한","빛나는")
    private val animals = listOf("고양이","강아지","너구리","앵무","수달","토끼","호랑이","여우","곰","사슴")

    fun getDisplayName(context: Context, authorKey: String): String {
        val sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        sp.getString(KEY_PREFIX + authorKey, null)?.let { return it }

        val hash = abs(authorKey.hashCode())
        val name = "${adjectives[hash % adjectives.size]} ${animals[(hash/7) % animals.size]}님"
        sp.edit().putString(KEY_PREFIX + authorKey, name).apply()
        return name
    }

}