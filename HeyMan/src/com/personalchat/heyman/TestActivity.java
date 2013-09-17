package com.personalchat.heyman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class TestActivity extends Activity {
	static final int CONNECTION_FAILURE = 0;
	static final int LOGIN_FAILURE = 1;
	static final int SUCCESS = 2;
	XMPPConnection connection;
	ChatManager chatmanager;
	Chat newChat;
	Button b1;
	ArrayAdapter<Spannable> adapter;
	ListView lv;
	ArrayList<Spannable> listItems = new ArrayList<Spannable>();
	String user2 = "admin";
	String user1 = "test";
	EditText sendMessageBox;
	
	ImoticonHandeler imobject;
	

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		
		
		imobject = new ImoticonHandeler(this);
		
		
		
		
		
		new Connection().execute(user1, "1234");

		
		
		
		
		
		
		
		
		sendMessageBox = (EditText) findViewById(R.id.editText1sndmsg);
		
		lv = (ListView) findViewById(R.id.listView1);
		
	
		adapter=new ArrayAdapter<Spannable>(this, R.layout.listelement, listItems);
		lv.setAdapter(adapter);
		
		
		
		
		b1 = (Button) findViewById(R.id.buttonaddtolist);


	}

	


	private class Connection extends AsyncTask<String, Void, Integer> {
		private Handler mHandler = new Handler();

		@Override
		protected Integer doInBackground(String... strings) {
			ConnectionConfiguration conConfig = new ConnectionConfiguration(
					"192.168.2.23", 5222, "localhost");
			connection = new XMPPConnection(conConfig);
			try {
				connection.connect();

				Log.i("AppName 1", "CONNECTED TO " + connection.getHost());
				Log.e("Service Name", connection.getServiceName());
			} catch (Exception e) {
				Log.e("AppName 2", e.getMessage());
				return CONNECTION_FAILURE;
			}
			try {
				connection.login(strings[0], strings[1]);
				Log.i("AppName 3", "LOGGED IN AS " + connection.getUser());
				Presence presence = new Presence(Presence.Type.available);
				connection.sendPacket(presence);

			} catch (Exception e) {
				Log.e("AppName 4", e.toString());
				return LOGIN_FAILURE;
			}
			try {
				Roster roster = connection.getRoster();
				Collection<RosterEntry> entries = roster.getEntries();
				for (RosterEntry entry : entries) {
					System.out.println(entry);
				}

			} catch (Exception e) {
				Log.e("AppName 5", e.toString());
			}

			return SUCCESS;
		}

		@Override
		protected void onPostExecute(Integer result) {
			if (result.equals(SUCCESS)) {
				chatmanager = connection.getChatManager();
				
				newChat = chatmanager.createChat(user2 + "@localhost", new MessageListener() {

		                    @Override
		                    public void processMessage(Chat chat, final Message msg) {

		                        mHandler.post(new Runnable() {

		                            @Override
		                            public void run() {
		                            		//listItems.add(""+msg.getBody()  imobject);
		                            		listItems.add(imobject.getSmiledText(msg.getBody().toString()));
		                    				adapter.notifyDataSetChanged();
		                    				lv.setSelection(lv.getAdapter().getCount()-1);
		                            	
		                            }
		                        });
		                        Log.wtf("AppName 5.5 ", msg.getBody());

		                    }
		                });
				
				
			

				b1.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						try {
							newChat.sendMessage(sendMessageBox.getText().toString());
							//chatHistoryBox.append("\n"+ "me : "+sendMessageBox.getText().toString());
						} catch (Exception e) {
							Log.e("AppName 6", e.toString());
						}

					}
				});
				
			
			}


		}

	}

}
