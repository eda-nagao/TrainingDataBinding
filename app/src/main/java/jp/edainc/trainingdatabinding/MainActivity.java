package jp.edainc.trainingdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import jp.edainc.trainingdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DataBindingUtilクラスを使ってインスタンスを取得する
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Bindingのインスタンスに、データを保持するクラスのインスタンスをセットする
        binding.setViewModel(new MainViewModel());

        // Bindingのインスタンスから画面の各要素にアクセスできる
        System.out.println(binding.addButton.getText());
    }
}
