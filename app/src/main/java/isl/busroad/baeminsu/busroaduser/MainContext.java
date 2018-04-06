package isl.busroad.baeminsu.busroaduser;

import android.app.Application;
import android.content.Context;

/**
 * Created by baeminsu on 2017. 10. 11..
 */

public class MainContext extends Application {

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }


    public static Context getContext() {
        return mContext;
    }

}
