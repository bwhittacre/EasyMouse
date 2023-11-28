package ch.thomaswhittacre.easymouse.ui.settings.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ch.thomaswhittacre.easymouse.R;

/**
 * This class is a sub fragment for the calibrate dialog, that is shown when the calibration process has finished.
 */
public class CalibrateFinishedSubdialog extends Fragment {


    /**
     * Creates the sub dialog.
     */
    public CalibrateFinishedSubdialog() {
        super(R.layout.subdialog_calibrate_finished);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
