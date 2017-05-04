package com.example.jubbahack.xnulls;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.app_preferences);

        Preference button = (Preference)findPreference(getString(R.string.startGame));
        if (button != null) {
            button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference gamefield) {
                    Intent intent = new Intent(getApplicationContext(), GameFieldActivity.class);
                    startActivity(intent);
                    return true;
                }
            });
        }
    }
}
