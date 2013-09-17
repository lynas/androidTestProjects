package com.personalchat.heyman;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

public class ImoticonHandeler {
	
	
	Context context;
	private HashMap<String, Integer> emoticons = new HashMap<String, Integer>();
	
	public ImoticonHandeler(Context c){
		context = c;
		emoticons.put(":-)", R.drawable.f01);
		emoticons.put(":P", R.drawable.f02);
		emoticons.put(":D", R.drawable.f03);
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
                            builder.setSpan(new ImageSpan(context, entry.getValue()), index, index + length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
