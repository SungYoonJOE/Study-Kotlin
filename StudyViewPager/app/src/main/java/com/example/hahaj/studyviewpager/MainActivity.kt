package com.example.hahaj.studyviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //뷰 객체들을 담을 리스트
    var view_list = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_list.add(layoutInflater.inflate(R.layout.view1, null))
        view_list.add(layoutInflater.inflate(R.layout.view2, null))
        view_list.add(layoutInflater.inflate(R.layout.view3, null))

        //페이지에 세팅
        pager.adapter = CustomAdapter()

        pager.addOnAdapterChangeListener(object : ViewPager.OnAdapterChangeListener{
            override fun onAdapterChanged(p0: ViewPager, p1: PagerAdapter?, p2: PagerAdapter?) {
                //p0이 현재 보여주는 뷰의 인덱스
                textView.text = "${p0} 번째 뷰가 나타남"
            }

            //onPageScroppStateChanged(state: Int){}

            //onPageSelected
        })
    }

    //PageAdapter클래스를 상속받은 클래스
    inner class CustomAdapter: PagerAdapter(){
        override fun getCount(): Int {
            //뷰페이저를 통해 반환할 뷰의 개수를 반환
            return view_list.size
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            //현재 객체가 보여줄 객체와 일치하는지 구분
            //p0 보여줄 뷰 객체 주소값, p1 안드로이드OS가 자기 필요에 의해 만든 여러 객체
            return p0 == p1
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            //항목을 구성하기 위해 호출할 메소드
            // 보여줄 뷰를 pager에 집어넣고 반환. position 현재 보여질 화면의 인덱스
            pager.addView(view_list[position])
            return view_list[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            //더 이상 안 보여지는 뷰를 제거하는 메소드
            pager.removeView(obj as View) //obj를 View객체로 형변환한 다음에 제거
        }
    }
}
