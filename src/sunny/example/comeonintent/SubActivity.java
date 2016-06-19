package sunny.example.comeonintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
public class SubActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);
		Button putExtra = (Button)findViewById(R.id.putExtra);
		putExtra.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("data_from_sub", "I am Sub");
				setResult(RESULT_OK,intent);//RESULT_OK -1;RESULT_CANCELED 0;
				finish();
			}
			
		});
	}
	  public void onBackPressed() {
//	      super.onBackPressed(); 这个要注释掉，然而没想懂为什么
	        Intent intent = new Intent();
	        intent.putExtra("data_from_sub","I am Sub");
	        setResult(RESULT_OK,intent);
	        finish();
	    }
}
