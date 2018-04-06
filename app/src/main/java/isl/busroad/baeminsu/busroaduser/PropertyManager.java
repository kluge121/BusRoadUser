package isl.busroad.baeminsu.busroaduser;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by baeminsu on 2017. 10. 11..
 */
public class PropertyManager {

    private static PropertyManager instance;

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mSp;
    SharedPreferences.Editor mEditor;

    private PropertyManager() {
        mSp = PreferenceManager.getDefaultSharedPreferences(MainContext.getContext());
        mEditor = mSp.edit();
    }
    private static final String AFFILIATION = "affiliation";



    public void setAffiliation(String affiliation) {
        mEditor.putString(AFFILIATION, affiliation);
        mEditor.commit();
    }


    public boolean getAutoLogin() {
//        Log.e("체크", mSp.getInt("first", 0) + "");
        if (mSp.getInt("first", 0) == 1) { // first값이 1 일때 오토로그인 , 0이면 로그인해야댑니당 헤헤
            return true;
        } else {
            return false;
        }

    }

    public String getAffiliation()

    {
        return mSp.getString(AFFILIATION, "");
    }

    public void setLogout(){
        mEditor.putInt("first", 0);
        mEditor.putString(AFFILIATION,"");
        mEditor.commit();
    }


}
