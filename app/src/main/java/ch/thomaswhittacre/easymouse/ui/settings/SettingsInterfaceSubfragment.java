package ch.thomaswhittacre.easymouse.ui.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import androidx.preference.PreferenceManager;
import ch.thomaswhittacre.easymouse.ui.settings.custom.SeekFloatPreference;
import ch.thomaswhittacre.easymouse.ui.settings.custom.SeekIntegerPreference;
import ch.thomaswhittacre.easymouse.R;

/**
 * This fragment is the settings page, where the user can configure things regarding the interface.
 */
public class SettingsInterfaceSubfragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_interface, null);

        SeekFloatPreference interfaceLayoutMiddleWidth = findPreference("interfaceLayoutMiddleWidth");
        interfaceLayoutMiddleWidth.setMaximum(0.5f);
        interfaceLayoutMiddleWidth.setMinimum(0.0f);
        interfaceLayoutMiddleWidth.setSteps(100);
        interfaceLayoutMiddleWidth.update();

        SeekFloatPreference interfaceLayoutHeight = findPreference("interfaceLayoutHeight");
        interfaceLayoutHeight.setMaximum(1.0f);
        interfaceLayoutHeight.setMinimum(0.0f);
        interfaceLayoutHeight.setSteps(100);
        interfaceLayoutHeight.update();

        SeekIntegerPreference interfaceVibrationsSpecialIntensity = findPreference("interfaceVibrationsSpecialIntensity");
        interfaceVibrationsSpecialIntensity.setMaximum(100);
        interfaceVibrationsSpecialIntensity.setMinimum(0);
        interfaceVibrationsSpecialIntensity.setSteps(100);
        interfaceVibrationsSpecialIntensity.update();

        SeekIntegerPreference interfaceVibrationsScrollIntensity = findPreference("interfaceVibrationsScrollIntensity");
        interfaceVibrationsScrollIntensity.setMaximum(100);
        interfaceVibrationsScrollIntensity.setMinimum(0);
        interfaceVibrationsScrollIntensity.setSteps(100);
        interfaceVibrationsScrollIntensity.update();

        SeekIntegerPreference interfaceVibrationsButtonIntensity = findPreference("interfaceVibrationsButtonIntensity");
        interfaceVibrationsButtonIntensity.setMaximum(100);
        interfaceVibrationsButtonIntensity.setMinimum(0);
        interfaceVibrationsButtonIntensity.setSteps(100);
        interfaceVibrationsButtonIntensity.update();

        SeekFloatPreference interfaceVisualsIntensity = findPreference("interfaceVisualsIntensity");
        interfaceVisualsIntensity.setMaximum(1.0f);
        interfaceVisualsIntensity.setMinimum(0.0f);
        interfaceVisualsIntensity.setSteps(100);
        interfaceVisualsIntensity.update();

        checkAdvanced();
    }

    public void checkAdvanced() {
        boolean advanced = PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean("advanced", false);
        findPreference("interfaceBehaviour").setVisible(advanced);
        findPreference("interfaceVisualsStrokeWeight").setVisible(advanced);
        findPreference("interfaceVisualsIntensity").setVisible(advanced);
        findPreference("interfaceVibrationsButtonIntensity").setVisible(advanced);
        findPreference("interfaceVibrationsButtonLength").setVisible(advanced);
        findPreference("interfaceVibrationsScrollIntensity").setVisible(advanced);
        findPreference("interfaceVibrationsScrollLength").setVisible(advanced);
        findPreference("interfaceVibrationsSpecialIntensity").setVisible(advanced);
        findPreference("interfaceVibrationsSpecialLength").setVisible(advanced);
        findPreference("interfaceLayout").setVisible(advanced);
    }
}
