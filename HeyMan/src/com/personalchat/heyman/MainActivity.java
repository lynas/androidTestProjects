package com.personalchat.heyman;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {
	Button button1;
	Button sendSpanB;
	TextView msgout;
	EditText mytext;
	private HashMap<String, Integer> emoticons = new HashMap<String, Integer>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendSpanB = (Button) findViewById(R.id.buttonsend);
		msgout = (TextView) findViewById(R.id.textView1);
		mytext = (EditText) findViewById(R.id.mychattext);
		button1 = (Button) findViewById(R.id.button1);
		
		
		
		emoticons.put(":-)", R.drawable.f01);
		emoticons.put(":P", R.drawable.f02);
		emoticons.put(":D", R.drawable.f03);
		
		
		
		
		
		
		sendSpanB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				/*Intent tui = new Intent(MainActivity.this, TestActivity.class);
				startActivity(tui);*/
				
				//msgout.setText("working");
				
				SpannableString spantext = new SpannableString(mytext.getText().toString());
				spantext.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 0,spantext.length(), 0);
				//msgout.setText(spantext);
				
				
				msgout.setText(getSmiledText(mytext.getText().toString()));
				

			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent tui = new Intent(MainActivity.this, TestActivity.class);
				startActivity(tui);
				

			}
		});

	}
	
	public Spannable getSmiledText(String text) {
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        if (emoticons.size() > 0) {
            int index;
            for (index = 0; index < builder.length(); index++) {
                if (Character.toString(builder.charAt(index)).equals(":")) {
                    for (Map.Entry<String, Integer> entry : emoticons.entrySet()) {
                        int length = entry.getKey().length();
                        if (index + length > builder.length())
                            continue;
                        if (builder.subSequence(index, index + length).toString().equals(entry.getKey())) {
                            builder.setSpan(new ImageSpan(this, entry.getValue()), index, index + length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            index += length - 1;
                            break;
                        }
                    }
                }
            }
        }
        return builder;
    }
}
