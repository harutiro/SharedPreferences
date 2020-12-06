package app.makino.harutiro.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //インスタンスを作る
        //ファイル操作のモード　Context.MODE_PRIVATE・Context.MODE_MULTI_PROCESS
        //                                getSharedPreferences(”設定データの名前”, ファイル操作のモード)
        val dataStore:SharedPreferences = getSharedPreferences("DateStore", Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            val stringText = editText.text.toString()
            saveText.text = stringText

            //  editorのオブジェクトを取得
            val editor = dataStore.edit()
            //　　　データ型（"ラベル名",代入するデータ）
            editor.putString("Input",stringText)

            //データの反映
            editor.apply()


        }

        readButton.setOnClickListener {


            // 　　　　インスタンス,読み込みのデータ型（"保存データのラベル名","何も入ってないときに初期化する値"）
            val str = dataStore.getString("Input","NoDate")
            readText.text = str


        }

    }
}