package ozgur.com.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import ozgur.com.news.api.APIService;
import ozgur.com.news.api.request.GetNewsRequest;
import ozgur.com.news.api.response.GetNewsResponse;
import ozgur.com.news.api.response.GetidResponse;
import ozgur.com.news.model.News;
import ozgur.com.news.model.NewsType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Goster extends AppCompatActivity {
    ImageView haberinResmi;
    TextView haberinBasligi,haberinTuru,haberinIcerigi,haberinYayinlanma,goruntu;
    Button begenmebuton,begenmemebuton;
    String baslik,resim,turu,icerik,tarihi;
    int id,begenme,begenmeme,izlenme;
    String url;
    GetNewsRequest request = new GetNewsRequest();
    APIService apiService = NewsApplication.getInstance().apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster);
        haberinResmi=(ImageView)(findViewById(R.id.imageView));
        haberinBasligi=(TextView)(findViewById(R.id.textView));
        haberinTuru=(TextView)(findViewById(R.id.textView2));
        haberinIcerigi=(TextView)(findViewById(R.id.textView3));
        haberinYayinlanma=(TextView)(findViewById(R.id.textView4));
        goruntu=(TextView)(findViewById(R.id.textView5));
        begenmebuton=(Button)(findViewById(R.id.button));
        begenmemebuton=(Button)(findViewById(R.id.button2));
        Bundle extras = getIntent().getExtras();
        baslik=extras.getString("baslik");
        resim=extras.getString("resim");
        turu=extras.getString("turu");
        icerik=extras.getString("icerik");
        tarihi=extras.getString("tarihi");
        id=extras.getInt("id");
        begenme=extras.getInt("begenme");
        begenmeme=extras.getInt("begenmeme");
        izlenme=extras.getInt("izlenme");
        haberinBasligi.setText(baslik);
        haberinTuru.setText(turu);
        haberinIcerigi.setText(icerik);
        haberinYayinlanma.setText(tarihi);
        url=resim;
        loadImageFromUrl(url);
        request.setId(id);
        Call<GetidResponse> idViewListele = apiService.idViewListele(request);
        idViewListele.enqueue(new Callback<GetidResponse>() {
            @Override
            public void onResponse(Call<GetidResponse> call, Response<GetidResponse> response) {
                if (response.isSuccessful()){

                    Toast.makeText(Goster.this,"Başarılı",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Goster.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetidResponse> call, Throwable t) {
                Toast.makeText(Goster.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        izlenme++;
        goruntu.setText("Görüntülenme Sayısı:"+izlenme);

    }
    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(haberinResmi, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
    public void begenme(View view){
        begenme++;
        begenmebuton.setText(String.valueOf(begenme));
        begenmebuton.setEnabled(false);
        begenmemebuton.setEnabled(false);
        request.setId(id);
        Call<GetidResponse> idLikeListele = apiService.idLikeListele(request);
        idLikeListele.enqueue(new Callback<GetidResponse>() {
            @Override
            public void onResponse(Call<GetidResponse> call, Response<GetidResponse> response) {
                if (response.isSuccessful()){

                    Toast.makeText(Goster.this,"Başarılı",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Goster.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetidResponse> call, Throwable t) {
                Toast.makeText(Goster.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void begenmme(View view){
        begenmeme++;
        begenmemebuton.setText(String.valueOf(begenmeme));
        begenmebuton.setEnabled(false);
        begenmemebuton.setEnabled(false);
        request.setId(id);
        Call<GetidResponse> idDisListele = apiService.idDisListele(request);
        idDisListele.enqueue(new Callback<GetidResponse>() {
            @Override
            public void onResponse(Call<GetidResponse> call, Response<GetidResponse> response) {
                if (response.isSuccessful()){

                    Toast.makeText(Goster.this,"Başarılı",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Goster.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetidResponse> call, Throwable t) {
                Toast.makeText(Goster.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
