package com.ckh.jim.activity

fun main() {
    val text = """
        ---
        title: aplayer+meting添加播放列表
        tags: 
        - 随笔
        - hexo
        date: 2020-12-28 09:01:15
        category: music
        ---
    """.trimIndent()
    var source = text
    val index = source.indexOf("#")
    println(index)
    source = source.substring(index, source.lastIndex)
    println(source)
}