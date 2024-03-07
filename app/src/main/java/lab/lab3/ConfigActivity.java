package lab.lab3;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConfigActivity extends Activity {
    int widgetID = AppWidgetManager.INVALID_APPWIDGET_ID;
    Intent resultValue;
    public final static String WIDGET_PREF = "widget_pref";
    public final static String WIDGET_TEXT = "widget_text_";
    public final static String WIDGET_COLOR = "widget_color_";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(SampleWidget.LOG_TAG, "onCreate config");

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null)
            widgetID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        if(widgetID == AppWidgetManager.INVALID_APPWIDGET_ID)
            finish();
        resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
        setResult(RESULT_CANCELED, resultValue);
        setContentView(R.layout.config);
    }

    public void onClick(View view) {
        int setRBColor = ((RadioGroup) findViewById(R.id.ergColor))
                .getCheckedRadioButtonId();
        int color = Color.RED;
        if(setRBColor == R.id.erbRed) color = Color.parseColor("#66ff0000");
        else if(setRBColor == R.id.erbGreen) color = Color.parseColor("#6600ff00");
        else if(setRBColor == R.id.erbBlue) color = Color.parseColor("#660000ff");
        ////////////////////////////////////////////////////////////////////////////////////
    }
}
