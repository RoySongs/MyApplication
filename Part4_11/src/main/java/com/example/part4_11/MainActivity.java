package com.example.part4_11;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* Spannable 방식 */

        TextView spanView = (TextView)findViewById(R.id.spannView);
        // setMovementMethod 와 new ScrollingMovementMethod클래스의 의미는??
        // setMovementMethod : Provides cursor positioning, scrolling and text selection functionality in a TextView.
        spanView.setMovementMethod(new ScrollingMovementMethod());

        String data = "복수초 \n img \n 이른봄 설산에서 만나는 복수초는 모든 야생화 찍사들의 로망이 아닐까 싶다.";

        SpannableStringBuilder builder = new SpannableStringBuilder(data);
        int start = data.indexOf("img");
        if(start >-1){
            // 끝나는 길이, 근데 왜 .은 뺏을까?
            int end = start+"img".length();
            // 그림 파일 가져오는 메소드
            Drawable dr = ResourcesCompat.getDrawable(getResources(), R.drawable.img1, null);
            // 위치 및 기본 크기 가져오기
            dr.setBounds(0,0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
            // 이미지 스팬 객체 생성
            ImageSpan span = new ImageSpan(dr);
            // 스팬을 설정한다
            builder.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // 꾸미고자 하는 문자열을 선택한다.
        start = data.indexOf("복수초");
        if(start>-1){
            int end = start+"복수초".length();
            // 스팬을 꾸밀 style을 정한다.
            StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
            // 상대적 사이즈 크기를 정하면 sizeSpan 객체 생성
            RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);
            // end에 +2를 해줬는데 의미는? 바뀐게 없다. 대신 +10을 주니 하이트가 늘어남.
            // SPAN INCLUSIVE와 EXCLUSIVE 차이는?
            builder.setSpan(styleSpan,start,end+2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            builder.setSpan(sizeSpan,start,end+2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            builder.insert(17, "CCCCC");
        }
        spanView.setText(builder);

        /* fromHTML방식 */
        TextView htmlView = (TextView)findViewById(R.id.htmlView);
        String html = "<font color='blue'>얼레지</font> <br/><img src='img1' /> <br/> 곰배령에서 만난 불꽃";
        // fromHtml메소드 방식을 이용한 span 꾸밈.
        htmlView.setText(Html.fromHtml(html, new MyImageGetter(), null));
    }

    class MyImageGetter implements Html.ImageGetter {
        public Drawable getDrawable(String source){
            if(source.equals("img1")){
                Drawable dr = ResourcesCompat.getDrawable(getResources(), R.drawable.img2, null);
                dr.setBounds(0,0, dr.getIntrinsicWidth(),dr.getIntrinsicHeight());
                return dr;
            }
            return null;
        }
    }

}

// http://re-build.tistory.com/13
// new ForegroundColorSpan(Color.RED) , new BackgroundColorSpan(Color.RED), new UnderlineSpan(), new AbsoluteSizeSpan(100) - 절대크기, new RelativeSizeSpan(1.5f) - 상대크기, new StyleSpan(Typeface.ITALIC) - 스타일 지정, new ImageSpan(이미지),
// new ClickableSpan(){ ...} - 클릭 효과 지정,  new URLSpan(링크주소)
// 기타 : AlignmentSpan, BulletSpan, LeadingMarginSpan, LineHeightSpan, QuoteSpan,TabStopSpan,WrapTogetherSpan, SpanWatcher