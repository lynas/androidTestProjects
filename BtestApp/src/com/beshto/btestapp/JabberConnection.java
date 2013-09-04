package com.beshto.btestapp;

import java.io.File;
import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;


import com.novell.sasl.client.DigestMD5SaslClient;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

public class JabberConnection implements MessageListener {

	XMPPConnection connection;

	public void login(String userName, String password) throws XMPPException {

		ConnectionConfiguration config = new ConnectionConfiguration(
				"ec2-23-22-213-29.compute-1.amazonaws.com", 5222);

		// SASLAuthentication.supportSASLMechanism("DIGEST-MD5", 0);
		config.setSASLAuthenticationEnabled(true);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			config.setTruststoreType("AndroidCAStore");
			config.setTruststorePassword(null);
			config.setTruststorePath(null);
		} else {
			config.setTruststoreType("BKS");
			String path = System.getProperty("javax.net.ssl.trustStore");
			if (path == null)
				path = System.getProperty("java.home") + File.separator + "etc"
						+ File.separator + "security" + File.separator
						+ "cacerts.bks";
			config.setTruststorePath(path);
		}

		// config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
		config.setDebuggerEnabled(true);
		connection = new XMPPConnection(config);
		// SASLAuthentication.supportSASLMechanism("PLAIN", 0);
		config.setSASLAuthenticationEnabled(true);
		// DigestMD5SaslClient
		

		AsyncTaskExaqmple myTask = new AsyncTaskExaqmple(userName, password);
		myTask.execute();
		
		
	}

	public void sendMessage(String message, String to) throws XMPPException {
		Chat chat = connection.getChatManager().createChat(to, this);
		chat.sendMessage(message);
	}

	public void displayBuddyList() {
		Roster roster = connection.getRoster();
		Collection<RosterEntry> entries = roster.getEntries();

		// System.out.println("\n\n" + entries.size() + " buddy(ies):");
		for (RosterEntry r : entries) {
			// System.out.println(r.getUser());
		}
	}

	public void disconnect() {
		connection.disconnect();
	}

	@Override
	public void processMessage(Chat chat, Message message) {
		if (message.getType() == Message.Type.chat)
			System.out.println(chat.getParticipant() + " says: "
					+ message.getBody());

	}
	
	private class AsyncTaskExaqmple extends AsyncTask<Void, Boolean, Boolean> {

		private String name;
		private String pass;
		

		AsyncTaskExaqmple(String n, String p) {
			this.name = n;
			this.name = p;
		}

		@Override
		protected void onPreExecute() {

		}

		@Override
		protected Boolean doInBackground(Void... params) {
			
			try{
				connection.connect();
				connection.login(name, pass);
				return true;
			}catch(Exception e){
				Log.d("Error !! ", e.toString());
				return false;
			}
		}

		@Override
		protected void onPostExecute(Boolean flag) {
			if(flag){
				Log.wtf("TAG", "IT WORKED");
				//Intent intent = new Intent(MainActivity.this,SelectUser.class);
				//startActivity(intent);
			}
		}

	}

}
