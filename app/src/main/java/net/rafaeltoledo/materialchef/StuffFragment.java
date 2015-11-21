package net.rafaeltoledo.materialchef;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StuffFragment extends Fragment {

    private TextInputLayout mMessageWrapper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stuff, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMessageWrapper = (TextInputLayout) view.findViewById(R.id.message_wrapper);

        view.findViewById(R.id.show_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageWrapper.setErrorEnabled(false);
                new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.error)
                        .setMessage(R.string.app_name)
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });

        view.findViewById(R.id.show_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageWrapper.setError(getString(R.string.error));
            }
        });
    }
}