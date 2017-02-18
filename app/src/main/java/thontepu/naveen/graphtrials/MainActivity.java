package thontepu.naveen.graphtrials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.graphView)
    Button lineGraph;
    @BindView(R.id.barGraph)
    Button barGraph;
    @BindView(R.id.barLineGraph)
    Button barLineGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.graphView, R.id.barGraph, R.id.barLineGraph})
    public void onClick(View view) {
        Intent intent = new Intent(this,Graph.class);
        switch (view.getId()) {
            case R.id.graphView:
                intent.putExtra("line",true);
                break;
            case R.id.barGraph:
                intent.putExtra("bar",true);
                break;
            case R.id.barLineGraph:
                intent.putExtra("point",true);
                break;
        }
        startActivity(intent);

    }
}
