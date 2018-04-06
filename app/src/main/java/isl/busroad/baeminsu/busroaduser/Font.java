package isl.busroad.baeminsu.busroaduser;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tsengvn.typekit.Typekit;
import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by baeminsu on 2017. 10. 11..
 */


public class Font extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "KoPubDotumLight.ttf"))
                .addBold(Typekit.createFromAsset(this, "KoPubDotumBold.ttf"));

        super.onCreate(savedInstanceState);
    }
}