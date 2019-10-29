package jp.edainc.trainingdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import jp.edainc.trainingdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewModelProvidersを使ってViewModelインスタンスを取得する
        // ofメソッドの引数に渡したインスタンスによって取得できるViewModelインスタンスが変わる
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // DataBindingUtilクラスを使ってインスタンスを取得する
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Bindingのインスタンスに、データを保持するクラスのインスタンスをセットする
        binding.setViewModel(viewModel);

        // Bindingのインスタンスから画面の各要素にアクセスできる
        System.out.println(binding.addButton.getText());
    }

    @Override
    protected void onDestroy() {
        viewModel.onCleared();
        super.onDestroy();
    }
}
