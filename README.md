实验三 AlertDialog

1.先安照题目要求写好layout.xml的布局
```
layout.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/header_logo"
        />
     </LinearLayout>
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        >
        <EditText
            android:id="@+id/tvMsg1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="Username"
            android:ems="30"
            android:maxLines="2"
            android:theme="@style/Username"
            />
        <EditText
            android:id="@+id/tvMsg2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="Password"
            android:ems="30"
            android:theme="@style/Password"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <Button
            android:id="@+id/one"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textAllCaps="false"
            android:background="@drawable/button_style"

            android:text="Cancle"/>
        <Button
            android:id="@+id/two"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textAllCaps="false"
            android:background="@drawable/button_style"
            android:text="Sign in"/>
    </LinearLayout>
</LinearLayout>
```
给边框上色 
```
button_style.xml
<?xml version="1.0" encoding="UTF-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- 边框颜色值设为灰色 -->
    <item>
        <shape>
            <solid android:color="@android:color/darker_gray" />
        </shape>
    </item>
    <!-- 按钮主体背景颜色,控件间的间距-->
    <item android:top="1dp"
           android:right="1dp"
           android:left="1dp">
        <shape>
            <solid android:color="@android:color/white" />
        </shape>
    </item>
</layer-list>
```
页面布局涉及到的新知识点
button里面默认的字母是大写,这一行是去除默认大写 android:textAllCaps="false"

2.创建一个MyDialog类,主要用于初始化自定义对话框中的按钮以及响应按钮的点击事件
```
package com.example.hp.alertdialog;
import android.app.Dialog ;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
/**
 * Created by hp on 2019/4/2.
 */
// 初始化自定义对话框中的控件以及响应按钮的点击事件
public class MyDialog extends Dialog{

    private String dialogName;
    private EditText tvMsg1;
    private EditText tvMsg2;
    private Button one;
    private Button two;

    public MyDialog(Context context,String dialogName) {

        super(context);
        this.dialogName=dialogName;

    }
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        //去除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //引入自定义对话框布局
        setContentView(R.layout.layout);
        tvMsg1=(EditText) findViewById(R.id.tvMsg1);
        tvMsg2=(EditText) findViewById(R.id.tvMsg2);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);

        //为"sign in"按钮设置点击事件
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击确定按钮时的操作
            }
        });
        //为“Cancle按钮设置点击事件”
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //点击取消按钮时关闭当前对话
                dismiss();
            }
        });
    }
}
```
结果截图:
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190403111349659.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ2MDUz,size_16,color_FFFFFF,t_70)
