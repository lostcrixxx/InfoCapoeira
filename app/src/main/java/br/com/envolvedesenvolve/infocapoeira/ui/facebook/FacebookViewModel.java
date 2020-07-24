package br.com.envolvedesenvolve.infocapoeira.ui.facebook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FacebookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FacebookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is facebook fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}