package ch.thomaswhittacre.easymouse.ui.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.google.android.material.snackbar.Snackbar;

import ch.thomaswhittacre.easymouse.transmission.DeviceStorage;
import ch.thomaswhittacre.easymouse.R;

/**
 * This fragment shows the settings that are used to configure the settings regarding communication.
 */
public class SettingsCommunicationSubfragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings_communication, null);

        Preference communicationRemoveDevices = findPreference("communicationRemoveDevices");

        communicationRemoveDevices.setOnPreferenceClickListener(preference -> {
            removeDevices();
            return true;
        });
    }

    /**
     * Shows the dialog where the user can choose to remove all known devices.
     */
    private void removeDevices() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.settings_communication_removeall_dialog_message)
                .setPositiveButton(R.string.settings_communication_removeall_dialog_remove, (dialog, id) -> {

                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();

                    editor.putString(DeviceStorage.DEVICES_KEY, "[]"); // Reset to an empty json array

                    editor.apply();

                    Snackbar.make(getView(), getResources().getString(R.string.settings_communication_removeall_confirmation), Snackbar.LENGTH_SHORT).show();

                })
                .setNegativeButton(R.string.settings_communication_removeall_dialog_cancel, (dialog, id) -> { });

        Dialog dialog = builder.create();
        dialog.show();
    }
}
