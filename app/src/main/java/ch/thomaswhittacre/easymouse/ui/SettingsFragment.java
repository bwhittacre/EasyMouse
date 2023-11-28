package ch.thomaswhittacre.easymouse.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import androidx.preference.SwitchPreference;
import com.google.android.material.snackbar.Snackbar;

import ch.thomaswhittacre.easymouse.customization.DefaultSettings;
import ch.thomaswhittacre.easymouse.R;

/**
 * This fragment contains the settings for the app.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, null);

        Preference reset = findPreference("reset");
        reset.setOnPreferenceClickListener(preference -> {
            resetSettings();
            return true;
        });

        checkAdvanced(PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean("advanced", false));
        findPreference("advanced").setOnPreferenceChangeListener((preference, newValue) -> {
            checkAdvanced((Boolean) newValue);
            return true;
        });
    }

    public void checkAdvanced(boolean advanced) {
        findPreference("reset").setVisible(advanced);
        findPreference("debugging").setVisible(advanced);
    }

    /**
     * Shows the settings reset dialog, where the user can choose to restore their settings.
     */
    private void resetSettings() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.settings_reset_dialog_message)
                .setPositiveButton(R.string.settings_reset_dialog_reset, (dialog, id) -> {

                    DefaultSettings.set(PreferenceManager.getDefaultSharedPreferences(getContext()));

                    Snackbar.make(getView(), getResources().getString(R.string.settings_reset_confirmation), Snackbar.LENGTH_SHORT).show();

                    boolean advanced = PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean("advanced", false);
                    checkAdvanced(advanced);
                    ((SwitchPreference)findPreference("advanced")).setChecked(advanced);
                })
                .setNegativeButton(R.string.settings_reset_dialog_cancel, (dialog, id) -> { });

        Dialog dialog = builder.create();
        dialog.show();
    }
}
