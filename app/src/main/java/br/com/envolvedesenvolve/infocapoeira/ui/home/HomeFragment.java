package br.com.envolvedesenvolve.infocapoeira.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.com.envolvedesenvolve.infocapoeira.MyWebViewClient;
import br.com.envolvedesenvolve.infocapoeira.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    WebView yt;
    ProgressBar pb,hb;
    String url = "https://www.youtube.com/channel/UCrSlNcLzS2L-nraVHRWOXJw";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        yt = (WebView) root.findViewById(R.id.webview_youtube);
        pb = (ProgressBar) root.findViewById(R.id.progressBar);
        hb = (ProgressBar) root.findViewById(R.id.horizontal_pb);

//        if(isNetworkAvailable()){
            yt.loadUrl(url);
//        }
//        else{
//            pb.setVisibility(View.GONE);
//            Snackbar snackbar = Snackbar
//                    .make(toolbar, "No Internet Connection..!", Snackbar.LENGTH_LONG)
//                    .setAction("RETRY", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent i = new Intent(MainActivity.this, MainActivity.class);
//                            finish();
//                            startActivity(i);
//                        }
//                    });
//            snackbar.setActionTextColor(Color.CYAN);
//            snackbar.show();
//        }
        WebSettings webSettings = yt.getSettings();
        webSettings.setJavaScriptEnabled(true);
        yt.setWebViewClient(new MyWebViewClient());

        yt.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                hb.setProgress(newProgress);
                if(newProgress==100){
                    pb.setVisibility(View.GONE);
                    hb.setVisibility(View.GONE);
                }
            }
        });

        return root;
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // Check if the key event was the Back button and if there's history
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && yt.canGoBack()) {
//            yt.goBack();
//            return true;
//        }
//        // If it wasn't the Back key or there's no web page history, bubble up to the default
//        // system behavior (probably exit the activity)
//        return super.onKeyDown(keyCode, event);
//    }

//    private boolean isInstalled(String uri){
//        PackageManager pm = getPackageManager();
//        boolean isIn;
//        try{
//            pm.getPackageInfo(uri,PackageManager.GET_ACTIVITIES);
//            isIn=true;
//        }catch(PackageManager.NameNotFoundException e){
//            isIn=false;
//        }
//        return isIn;
//    }

//    private boolean isNetworkAvailable() {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }
}
