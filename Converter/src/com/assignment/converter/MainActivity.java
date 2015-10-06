package com.assignment.converter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Spinner spinnerConverter;
	EditText bigValues;
	EditText smallValues;
	Button converter,clear;
	TextView result;
	double km,m;
	double cel,fa;
	double dl,rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        spinnerConverter=(Spinner) findViewById(R.id.spinner1);
        bigValues=(EditText) findViewById(R.id.editText1);
        smallValues=(EditText) findViewById(R.id.editText2);
        converter=(Button) findViewById(R.id.buttonConvert);
        result=(TextView) findViewById(R.id.textView1);
        clear=(Button) findViewById(R.id.buttonClear);
        
        
        final String[] listconvertor={"Length","Temperature","Currency"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, listconvertor);
        spinnerConverter.setAdapter(adapter);
        
        spinnerConverter.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				switch (pos) {
				case 0:
					bigValues.setHint("Kilometer");
					smallValues.setHint("Meter");
					converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							if((bigValues.getText().length()>0)&&(smallValues.getText().length()>0)){
								result.setText("Enter single field");
							}
							else if(bigValues.getText().length()>0){
								
								km=Double.parseDouble(bigValues.getText().toString());
								m=km*1000;
								result.setText("Result:"+m+"m");
							}
							else if (smallValues.getText().length()>0) {
								m=Double.parseDouble(smallValues.getText().toString());
								km=m/1000;
								result.setText("Result:"+km+"km");
								
							}
							
							else{
								result.setText("Enter some Values");
							}
							
						}
					});
					break;
				case 1:
					bigValues.setHint("Celsius");
					smallValues.setHint("Fahrenheit");
					converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							if((bigValues.getText().length()>0)&&(smallValues.getText().length()>0)){
								result.setText("Enter single field");
							}
							
							else if(bigValues.getText().length()>0){
								cel=Double.parseDouble(bigValues.getText().toString());
								fa=(cel*1.8)+32;
								result.setText("Result:"+fa+"f");
							}
							else if (smallValues.getText().length()>0) {
								fa=Double.parseDouble(smallValues.getText().toString());
								cel=(fa-32)/1.8;
								result.setText("Result:"+cel+"c");
								
							}
							else{
								result.setText("Enter some Values");
							}
							
						}
					});
					
					break;
					
					
					
					
					
					
					
				case 2:
					bigValues.setHint("Dolar");
					smallValues.setHint("Rupee");
					converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							if((bigValues.getText().length()>0)&&(smallValues.getText().length()>0)){
								result.setText("Enter single field");
							}
							
							else if(bigValues.getText().length()>0){
								dl=Double.parseDouble(bigValues.getText().toString());
								rs=dl*66.16;
								result.setText("Result:"+rs+"rs");
							}
							else if (smallValues.getText().length()>0) {
								rs=Double.parseDouble(smallValues.getText().toString());
								dl=rs*0.15;
								result.setText("Result:"+dl+"$");
								
							}
							else{
								result.setText("Enter some Values");
							}
							
							
						}
					});
					
					
					break;

				default:
					break;
				}
				
				
				
				
				clear.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						bigValues.setText("");
						smallValues.setText("");
						result.setText("");
						
						
					}
				});
						
						
						
						
							
								
								
							
						
						
					
						
						
						
					}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
				});
				
			}
			
			

		
        		
  


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
