package com.personalchat.heyman;

import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		login();
	}

	public void login() {
		new Connection().execute("admin", "1234");
	}

	private class Connection extends AsyncTask<String, Void, Integer> {
		private static final int CONNECTION_FAILURE = 0;
		private static final int LOGIN_FAILURE = 1;
		private static final int SUCCESS = 2;
		XMPPConnection connection;

		@Override
		protected Integer doInBackground(String... strings) {
			ConnectionConfiguration conConfig = new ConnectionConfiguration("192.168.2.6", 5222,"localhost");  
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
			try{
				Roster roster = connection.getRoster();
				Collection<RosterEntry> entries = roster.getEntries();
				for (RosterEntry entry : entries) {
				    System.out.println(entry);
				}
 
			}catch(Exception e){
				Log.e("AppName 5", e.toString());
			}
			
			
			ChatManager chatmanager = connection.getChatManager();
			Chat newChat = chatmanager.createChat("test@localhost", new MessageListener() {
				
				@Override
				public void processMessage(Chat chat, Message msg) {
					// TODO Auto-generated method stub
					Log.wtf("AppName 5.5", ""+msg);
					
				}
			});
			try {
			    newChat.sendMessage("Howdy!");
			}
			catch (Exception e) {
				Log.e("AppName 6", e.toString());
			}
			

			return SUCCESS;
		}
	}

}
