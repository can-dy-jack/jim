package com.ckh.jim.activity

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.annotation.ColorInt
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.ckh.jim.MagicHttp
import com.ckh.jim.databinding.ActivityBlogContentBinding
import com.ckh.jim.util.runOnMainThread
import io.noties.markwon.Markwon
import io.noties.markwon.core.CorePlugin


class BlogContentActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_WEBSITE = "https://kartjim.gitee.io/seadocs/jim"
        const val EXTRA_STRING_URL = "string_url"
    }

    private lateinit var binding: ActivityBlogContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()
    }

    private var markdownSource = ""

    private fun initView() {
        val url = intent.getStringExtra(EXTRA_STRING_URL)

        binding.apply {

            if (url != null) {
                tvTitle.text = url.replace(".md", "")
            }

            val mdUrl = "${DEFAULT_WEBSITE}/source/${url}"

            MagicHttp.OkHttpManager().newGet(mdUrl, {
                runOnMainThread {
                    var source = it
                    val index = source.indexOf("#")
                    if (index != -1) {
                        source = source.substring(index, source.lastIndex + 1)
                    }

                    // val prism4j = Prism4j(GrammarLocatorDef())


                    val markwon = Markwon
                        .builder(this@BlogContentActivity)
//                        .usePlugin(GlideImagesPlugin.create(this@BlogContentActivity))
//                        .usePlugin(GlideImagesPlugin.create(Glide.with(this@BlogContentActivity)))
//                        .usePlugin(GlideImagesPlugin.create(object : GlideImagesPlugin.GlideStore {
//                            override fun load(drawable: AsyncDrawable): RequestBuilder<Drawable> {
//                                return Glide.with(this@BlogContentActivity)
//                                    .load(drawable.destination);
//                            }
//
//                            override fun cancel(target: Target<*>) {
//                                Glide.with(this@BlogContentActivity).clear(target)
//                            }
//                        }))
                        .usePlugin(CorePlugin.create())
//                        .usePlugin(
//                            SyntaxHighlightPlugin.create(
//                                Prism4j(GrammarLocator()),
//                                prism4jTheme
//                            )
//                        )
                        .build()
                    markwon.setMarkdown(tvMarkdown, source)

//                    val builder = SpannableBuilder()
//                    val visitor = CodeVisitor(
//                        spannableBuilder,
//                        builder,
//                        spannableTheme,
//                        resources.getColor(R.color.codeTextColor) //Note: code text color
//                    )
//
//                    Markwon.createParser().parse("a simple `code`").accept(visitor)
//                    tvContent.text = builder.text()


                    // binding.markdownWebView.setText(source)
                }
            }, {

            })

//            etMarkdown.addTextChangedListener(object : TextWatcher {
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//                override fun afterTextChanged(s: Editable) {
//                    binding.markdownWebView.setText(etMarkdown.text.toString())
//                }
//            })

            btnChange.setOnClickListener {

            }
        }
    }

    private fun initListener() {
        binding.apply {
            ivBack.setOnClickListener {
                finish()
            }
        }
    }
}

//interface Prism4jTheme {
//    @ColorInt
//    fun background(): Int
//
//    @ColorInt
//    fun textColor(): Int
//    fun apply(
//        @NonNull language: String?,
//        @NonNull syntax: Prism4j.Syntax?,
//        @NonNull builder: SpannableStringBuilder?,
//        start: Int,
//        end: Int
//    )
//}
