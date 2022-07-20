package ir.harmoniclearn.first;
 //import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.*;
public class MainActivity extends AppCompatActivity 
{
	long  total=0;

	TextView  tv;
	char opt='#';
	boolean showResult=false;
	Button  buttonDoo;
	Button  buttonChar;
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		tv= findViewById(R.id.tvResult);
        buttonChar=findViewById(R.id.chahar);
		buttonChar.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					doType("4");
				}
			}
		);
		buttonDoo=findViewById(R.id.doo);
		buttonDoo.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					doType("2");
				}
			}    
		);

    }
	public void clickYek(View v){
		doType("1");
	}
	public void clickThree (View v){
		doType("3");
	}
	public void clickPlus(View v){
		doOperate('+');
	}

	public void clickMinus(View v){
		doOperate('-');
	}
	public void clickDivide(View v){
		doOperate('/');
	}
	public void clickClear(View v){
		String s="نتیجه: 0";
		tv.setText(s);
		opt='#';
		showResult=false;
		total=0;
	}
    public void clickEqual(View v){
		String   txt=tv.getText().toString();
		String temp=txt.substring(7);
		long l=Long.parseLong(temp);

		if(opt=='+'){
			total=total+l;
			showResult=true;
		}
		else if(opt=='-'){
			total=total-l;
			showResult=true;
		}
		else if(opt=='/')
		{
			if(l!=0){
				total=total/l;
				showResult=true;
			}
			else
				Toast.makeText(MainActivity.this
							   ,"خطا: تقسیم بر صفر",Toast.LENGTH_LONG)
					.show();



		}
		if(showResult==true){
			txt=String.valueOf(total);  
			String s="نتیجه: ";
			tv.setText(s+txt);
		}

	}
	public  void doType(String label){
		String   txt=tv.getText().toString();
		String temp=txt.substring(7);
		long l=Long.parseLong(temp);
		if(l==0)
			txt=label;
		else if(showResult==true){
			txt=label;
			showResult=false;
			opt='#';
			total=0;
		}
		else
			txt=temp+label;
		String s="نتیجه: ";
		tv.setText(s+txt);
	}
	public void doOperate(char opration){
		opt=opration;
		String   txt=tv.getText().toString();
		String temp=txt.substring(7);
		total=Long.parseLong(temp);
		String s="نتیجه: 0" ;
		tv.setText(s);
	}
}
