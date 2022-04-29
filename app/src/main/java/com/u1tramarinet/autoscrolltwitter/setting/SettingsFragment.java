package com.u1tramarinet.autoscrolltwitter.setting;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.u1tramarinet.autoscrolltwitter.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}