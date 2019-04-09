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
