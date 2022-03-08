package mq.mqandroidworld.customviewtest

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import mq.mqandroidworld.customviewtest.databinding.ViewMyCustomBinding


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayoutCompat(context, attrs) {
    private val binding = ViewMyCustomBinding.inflate(LayoutInflater.from(context),this)

    init {
        //LayoutInflater.from(context).inflate(R.layout.view_my_custom, this, true)
        orientation = VERTICAL


        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.CustomView,0,0
            )
            val title = resources.getText(typedArray.getResourceId(
                R.styleable.CustomView_my_custom_title,
                R.string.app_name
            ))
            val hint = resources.getText(typedArray.getResourceId(
                R.styleable.CustomView_my_custom_hint,
                R.string.app_name
            ))
            val isSwitch = typedArray.getBoolean(R.styleable.CustomView_my_custom_switch,false)
            // 값 저장
            binding.myTitle.text = title
            binding.myHint.hint = hint
            binding.mySwitch.isChecked = isSwitch
            
            typedArray.recycle()    // typedArray 의 재사용
        }
    }
    fun getTitle():String = binding.myTitle.text.toString()
    fun setTitle(str:String){
        binding.myTitle.text = str
    }
}

/***
 * 참고 사이트
 * https://pluu.github.io/blog/android/2020/08/09/android-custom-view-style/
 * https://wiserloner.tistory.com/1373
 */