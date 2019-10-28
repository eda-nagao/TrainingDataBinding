package jp.edainc.trainingdatabinding;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class MainViewModel {
    // ObservableFieldは、非同期的に値を変更したり、変更を通知したりできるオブジェクト
    private ObservableInt counter = new ObservableInt(0);
    private ObservableField<String> copiedCount = new ObservableField<>("");

    public ObservableInt getCounter() {
        return counter;
    }

    public ObservableField<String> getCopiedCount() {
        return copiedCount;
    }

    // OnClickにバインドするためのメソッド
    // OnClickListenerインターフェースに合わせて作成する
    public void addCount(View view) {
        counter.set(counter.get() + 1);
    }

    // OnClickにバインドするためのメソッド
    public void copyCount(View view) {
        copiedCount.set(String.valueOf(counter.get()));
    }
}
