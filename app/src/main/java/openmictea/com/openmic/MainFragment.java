package openmictea.com.openmic;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by knits4 on 4/13/18.
 */

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_layout, container, false);

        TextView address = rootView.findViewById(R.id.address);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity().getApplicationContext();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + "913 Main Street, Antioch, IL 60002");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                context.startActivity(mapIntent);
            }
        });

        TextView phoneNumber = rootView.findViewById(R.id.phone);
        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "tel:" + " 8478770723" ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                PackageManager packageManager = getActivity().getPackageManager();
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Phone App: ", "No Intent available to handle action");
                }
            }
        });

        return rootView;

    }



}
