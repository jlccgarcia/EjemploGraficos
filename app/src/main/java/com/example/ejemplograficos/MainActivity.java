package com.example.ejemplograficos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw (Canvas canvas) {
            /* Uso de Paint y Canvas
            Paint pincel=new Paint();
            pincel.setColor(Color.GREEN);
            pincel.setStrokeWidth(8);
            pincel.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(150, 150, 100, pincel);
            pincel.setColor(0xff234dff);
            canvas.drawLine(250, 200, 350, 300, pincel);
            pincel.setColor(Color.argb(255, 255,0,0));
            canvas.drawPoint(450, 450, pincel);
            canvas.drawPoint(500, 500, pincel);
            pincel.setColor(Color.argb(127,255,0,0));
            canvas.drawCircle(150,250,100, pincel);
            pincel.setColor(getResources().getColor(R.color.color_circulo));
            canvas.drawRect(600, 600, 700, 400, pincel);
            */
            //Uso de Path, Paint y Canvas
            Path trazo = new Path();
            //Dirección del trazo: CCW (contra agujas reloj), CW (a favor agujas del reloj)
            //trazo.addCircle(350, 300, 100, Path.Direction.CCW);
            //La siguiente línea iría con la drawTextOnPath comentada de abajo --> Sentido agujas del reloj y por fuera del círculo
            //trazo.addCircle(350, 300, 100, Path.Direction.CW);

            //Ejercicio pág 204
            trazo.moveTo(50, 100);
            trazo.cubicTo(60,70, 150,65, 200,110);
            trazo.lineTo(400,300);

            canvas.drawColor(Color.GRAY);
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(8);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawPath(trazo, pincel);
            pincel.setStrokeWidth(1);
            pincel.setStyle(Paint.Style.FILL);
            pincel.setTextSize(20);
            pincel.setTypeface(Typeface.SANS_SERIF);
            canvas.drawTextOnPath("Desarrollo de aplicaciones para móviles con Android", trazo, 10, 40, pincel);
            //canvas.drawTextOnPath("Desarrollo de aplicaciones para móviles con Android", trazo, -10, -40, pincel);
        }
    }
}
