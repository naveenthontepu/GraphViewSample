package thontepu.naveen.graphtrials;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Graph extends AppCompatActivity {

    @BindView(R.id.graphView)
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_graph);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            if (getIntent().getExtras().getBoolean("line", false)) {
                lineData();
            }
            if (getIntent().getExtras().getBoolean("bar", false)) {
                barData();
            }
            if (getIntent().getExtras().getBoolean("point", false)) {
                pointData();

            }
        }
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScrollableY(true);
        graphView.getViewport().setScalableY(true);

    }

    private void barData() {
        DataPoint[] dataPoints = new DataPoint[]{
                new DataPoint(1, 0),
                new DataPoint(2, 23),
                new DataPoint(3, 15),
                new DataPoint(4, 46),
                new DataPoint(5, 52),
                new DataPoint(6, 16),
                new DataPoint(7, 42),
                new DataPoint(8, 26),
                new DataPoint(9, 0),
        };
        BarGraphSeries<DataPoint> barGraphSeries = new BarGraphSeries<>(dataPoints);
        graphView.addSeries(barGraphSeries);
        barGraphSeries.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });
        barGraphSeries.setDrawValuesOnTop(true);
        barGraphSeries.setValuesOnTopColor(Color.RED);
        barGraphSeries.setSpacing(30);
    }


    private void barData1() {
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d4 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d5 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d6 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d7 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d8 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d9 = calendar.getTime();

        DataPoint[] dataPoints = new DataPoint[]{
                new DataPoint(d1, 0),
                new DataPoint(d2, 23),
                new DataPoint(d3, 15),
                new DataPoint(d4, 46),
                new DataPoint(d5, 52),
                new DataPoint(d6, 16),
                new DataPoint(d7, 42),
                new DataPoint(d8, 26),
                new DataPoint(d9, 0),
        };
        BarGraphSeries<DataPoint> barGraphSeries = new BarGraphSeries<>(dataPoints);
        graphView.addSeries(barGraphSeries);
        graphView.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graphView.getGridLabelRenderer().setHorizontalLabelsAngle(120);
        graphView.getGridLabelRenderer().setNumHorizontalLabels(7);
        graphView.getGridLabelRenderer().setHumanRounding(false);
        graphView.getViewport().setMinX(d1.getTime());
        graphView.getViewport().setMaxX(d6.getTime());
        graphView.getViewport().setXAxisBoundsManual(true);
        barGraphSeries.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });
        barGraphSeries.setDrawValuesOnTop(true);
        barGraphSeries.setValuesOnTopColor(Color.RED);
        barGraphSeries.setSpacing(30);
    }

    private void pointData() {
        DataPoint[] dataPoints = new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(12, 13),
                new DataPoint(23, 23),
                new DataPoint(28, 15),
                new DataPoint(34, 46),
                new DataPoint(35, 52),
                new DataPoint(60, 67)
        };
        PointsGraphSeries<DataPoint> pointPointsGraphSeries = new PointsGraphSeries<>(dataPoints);
        graphView.addSeries(pointPointsGraphSeries);
    }

    public void lineData() {
        DataPoint[] dataPoints = new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(12, 13),
                new DataPoint(23, 23),
                new DataPoint(28, 15),
                new DataPoint(34, 46),
                new DataPoint(35, 52),
                new DataPoint(60, 67)
        };
        LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<>(dataPoints);
        graphView.addSeries(lineGraphSeries);
    }
}
