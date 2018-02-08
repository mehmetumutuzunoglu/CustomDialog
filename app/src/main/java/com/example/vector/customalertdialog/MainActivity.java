package com.example.vector.customalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomDialogClass customDialog = new CustomDialogClass(this, "Merhaba",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
                , "evet");
        customDialog.show();

    }

    public class CustomDialogClass extends Dialog implements View.OnClickListener {

        private Button btnSingleOk;
        private Button btnDoubleOk;
        private Button btnDoubleCancel;
        private TextView txtTitle;
        private TextView txtSubtitle;

        private String title;
        private String subtitle;
        private String btnText;
        private String btnTextSecond;

        private LinearLayout doubleButtonLayout;

        public CustomDialogClass(Context context, String title, String subtitle, String btnText) {
            super(context);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            this.title = title;
            this.subtitle = subtitle;
            this.btnText = btnText;
            this.btnTextSecond = "";
        }

        public CustomDialogClass(Context context, String title, String subtitle, String btnText, String btnTextSecond) {
            super(context);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            this.title = title;
            this.subtitle = subtitle;
            this.btnText = btnText;
            this.btnTextSecond = btnTextSecond;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.custom_dialog);

            txtTitle = (TextView) findViewById(R.id.custom_dialog_txtTitle);
            txtSubtitle = (TextView) findViewById(R.id.custom_dialog_txtSubtitle);
            btnSingleOk = (Button) findViewById(R.id.custom_dialog_btnSingleOk);
            btnDoubleOk = (Button) findViewById(R.id.custom_dialog_btnDoubleOk);
            btnDoubleCancel = (Button) findViewById(R.id.custom_dialog_btnDoubleCancel);
            doubleButtonLayout = (LinearLayout) findViewById(R.id.custom_dialog_double_button_layout);

            txtTitle.setText(title);
            txtSubtitle.setText(subtitle);
            btnSingleOk.setText(btnText);

            if (!btnTextSecond.isEmpty()) {
                btnSingleOk.setVisibility(View.GONE);
                doubleButtonLayout.setVisibility(View.VISIBLE);
                btnDoubleOk.setText(btnText);
                btnDoubleCancel.setText(btnTextSecond);
            }

            btnSingleOk.setOnClickListener(this);
            btnDoubleOk.setOnClickListener(this);
            btnDoubleCancel.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.custom_dialog_btnSingleOk:
                    dismiss();
                    break;
                case R.id.custom_dialog_btnDoubleOk:
                    dismiss();
                    break;
                case R.id.custom_dialog_btnDoubleCancel:
                    dismiss();
                default:
                    break;
            }
        }
    }

}

