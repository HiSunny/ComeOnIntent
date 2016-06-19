package sunny.example.comeonintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
public class ThridActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.third);
		Button putExtra = (Button)findViewById(R.id.putExtra1);
		putExtra.setOnClickListener(new OnClickListener(){

	@Override
	public void onClick(View v) {
				// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.putExtra("data_from_third", "I am third");
		setResult(RESULT_OK,intent);
		finish();
			}
			});
		
	}

	//当不是按下Button返回而是按下Back键返回，重写onBackPressed()返回数据
	@Override
	public void onBackPressed(){
		Intent intent = new Intent();
		intent.putExtra("data_from_third", "I am third");
		setResult(RESULT_OK,intent);
		finish();
	}
}
