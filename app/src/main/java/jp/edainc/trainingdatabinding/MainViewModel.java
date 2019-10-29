package jp.edainc.trainingdatabinding;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // LiveDataはObservableFieldと同じ、値の変更を通知できるオブジェクト
    // ObservableFieldと違い、値を監視しているActivity/Fragmentが破棄されたら自動で関係をクリアする
    // (＝エラーが起きなくなり安全）
    private MutableLiveData<Integer> counter = new MutableLiveData<>(0);
    private MutableLiveData<String> copiedCount = new MutableLiveData<>("");

    public LiveData<Integer> getCounter() {
        return counter;
    }

    public LiveData<String> getCopiedCount() {
        return copiedCount;
    }

    // OnClickにバインドするためのメソッド
    // OnClickListenerインターフェースに合わせて作成する
    public void addCount(View view) {
        final Integer counterValue = counter.getValue();
        if (counterValue != null) {
            counter.postValue(counterValue + 1);
            // counter.setValue(counterValue + 1);
            // 上のようにも書ける。違いはスレッドに対する扱い。
            // setValueメソッドをメインスレッド以外から呼び出すとエラーになる。
        }
    }

    // OnClickにバインドするためのメソッド
    public void copyCount(View view) {
        copiedCount.postValue(String.valueOf(counter.getValue()));
    }

    @Override
    protected void onCleared() {
        // 非同期処理などを使っている場合はこのタイミングでキャンセルする
        super.onCleared();
    }
}
