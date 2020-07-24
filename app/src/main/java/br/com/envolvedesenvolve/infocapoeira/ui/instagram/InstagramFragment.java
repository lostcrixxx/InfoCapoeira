package br.com.envolvedesenvolve.infocapoeira.ui.instagram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import br.com.envolvedesenvolve.infocapoeira.MyWebViewClient;
import br.com.envolvedesenvolve.infocapoeira.R;

public class InstagramFragment extends Fragment {

    private InstagramViewModel instagramViewModel;

    WebView yt;
    ProgressBar pb, hb;
    String url = "https://www.instagram.com/infocapoeira";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_instagram, container, false);

        yt = (WebView) root.findViewById(R.id.webview_youtube);
        pb = (ProgressBar) root.findViewById(R.id.progressBar);
        hb = (ProgressBar) root.findViewById(R.id.horizontal_pb);

        yt.loadUrl(url);

        WebSettings webSettings = yt.getSettings();
        webSettings.setJavaScriptEnabled(true);
        yt.setWebViewClient(new MyWebViewClient());

        yt.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                hb.setProgress(newProgress);
                if (newProgress == 100) {
                    pb.setVisibility(View.GONE);
                    hb.setVisibility(View.GONE);
                }
            }
        });

        return root;
    }
}