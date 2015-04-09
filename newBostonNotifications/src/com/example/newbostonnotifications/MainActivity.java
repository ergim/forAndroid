package com.example.newbostonnotifications;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	
	
	NotificationCompat.Builder notification;
	private static final int uniqueID=45612;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		notification=new NotificationCompat.Builder(this);
		notification.setAutoCancel(true);
	}
	
	public void btnNot(View view){
		notification.setSmallIcon(R.drawable.ic_launcher);
		notification.setTicker("This is the ticker");
		notification.setWhen(System.currentTimeMillis());
		notification.setContentTitle("Here is the titile");
		notification.setContentText("I am the body text of your notification");
		
		Intent intent=new Intent(this, MainActivity.class);
		PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		notification.setContentIntent(pendingIntent);
		
		//build notification and issue
		NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.notify(uniqueID, notification.build());
		
	}

	
}
