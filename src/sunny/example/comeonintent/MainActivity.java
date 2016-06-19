package sunny.example.comeonintent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;
import android.widget.TextClock;
import android.app.AlertDialog;
import android.app.ProgressDialog;
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextClock tc = (TextClock)findViewById(R.id.textClock);
		tc.setFormat12Hour("EEEE, MMMM dd, yyyy h:mmaa");
		//tc.setFormat24Hour("yyyy-MM-dd hh:mm, EEEE");
		
	}
/*
 * 设置属性值示例(1970/04/06 3:23am)
"MM/dd/yy h:mmaa" -> "04/06/70 3:23am"
"MMM dd, yyyy h:mmaa" -> "Apr 6, 1970 3:23am"
"MMMM dd, yyyy h:mmaa" -> "April 6, 1970 3:23am"
"E, MMMM dd, yyyy h:mmaa" -> "Mon, April 6, 1970 3:23am&
"EEEE, MMMM dd, yyyy h:mmaa" -> "Monday, April 6, 1970 3:23am"
"'Noteworthy day: 'M/d/yy" -> "Noteworthy day: 4/6/70"*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
		case R.id.add:
			//AlertDialog.THEME_TRADITIONAL|AlertDialog.THEME_HOLO_DARK|AlertDialog.THEME_HOLO_LIGHT
			//AlertDialog.THEME_HOLO_LIGHT比较好看，浅蓝 白
			AlertDialog.Builder ad = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);
			ad.setTitle("AlertDialog");
			ad.setIcon(R.drawable.ic_launcher);
			ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			//ad.setCancelable(true);
			ad.setNegativeButton("Cnacel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			ad.show();
			Intent intent1 = new Intent("sunny.example.comeonintent.ACTION");
			//void android.support.v4.app.FragmentActivity
			//.startActivityForResult(Intent intent, int requestCode)
			startActivityForResult(intent1,1);
			break; 
		case R.id.remove:
			
			ProgressDialog p = new ProgressDialog(this);
			p.setTitle("ProgressDialog");
			p.setMessage("Loading...");
			p.show();
			Intent intent2 = new Intent(this,ThridActivity.class);
			startActivityForResult(intent2,2);
			break;
			default:
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int RequestCode,int ResultCode,Intent data){
		TextView tv1 = (TextView)findViewById(R.id.tv1);
		TextView tv2 = (TextView)findViewById(R.id.tv2);
		switch(RequestCode){
		case 1:
			if(ResultCode == RESULT_OK){
				String returnData1 = data.getStringExtra("data_from_sub");
				tv1.setText(returnData1);
			}else{}
		case 2:
			if(ResultCode == RESULT_OK){
				String returnData2 = data.getStringExtra("data_from_third");
				tv2.setText(returnData2);
			}else{
				
				}
		default:
		}
		
	}

}
