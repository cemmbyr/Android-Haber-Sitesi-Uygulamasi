package ozgur.com.news;

import android.content.Intent;
import android.support.v4.view.NestedScrollingChild;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ozgur.com.news.api.APIService;
import ozgur.com.news.api.request.GetNewsRequest;
import ozgur.com.news.api.response.GetNewsResponse;
import ozgur.com.news.model.News;
import ozgur.com.news.model.NewsType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    APIService apiService = NewsApplication.getInstance().apiService;
    GetNewsRequest request = new GetNewsRequest();
    ArrayList<News> yeniHaberler =new ArrayList<News>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)(findViewById(R.id.listview1));


    }


        public void genel(View view){
        yeniHaberler.clear();
        request.setType(NewsType.Genel);
        Call<GetNewsResponse> verilerimilistele = apiService.verilerimilistele(request);
            verilerimilistele.enqueue(new Callback<GetNewsResponse>() {
                @Override
                public void onResponse(Call<GetNewsResponse> call, final Response<GetNewsResponse> response) {
                    if (response.isSuccessful()){
                        GetNewsResponse newsResponse = response.body();
                        final List<News> newsList = newsResponse.getNewsList();
                        final String [] genell=new String[newsList.size()];
                        for(int i=0;i<newsList.size();i++){
                           genell[i]=newsList.get(i).getTitle();
                           yeniHaberler.add(newsList.get(i));
                        }
                        ArrayAdapter<String> genelladapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,genell);
                        listView.setAdapter(genelladapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent=new Intent(getApplicationContext(),Goster.class);
                                intent.putExtra("baslik",yeniHaberler.get(position).getTitle());
                                intent.putExtra("resim",yeniHaberler.get(position).getImage());
                                intent.putExtra("turu",yeniHaberler.get(position).getType());
                                intent.putExtra("icerik",yeniHaberler.get(position).getDescription());
                                intent.putExtra("tarihi",yeniHaberler.get(position).getPublishDate());
                                intent.putExtra("id",yeniHaberler.get(position).getId());
                                intent.putExtra("begenme",yeniHaberler.get(position).getLikeCount());
                                intent.putExtra("begenmeme",yeniHaberler.get(position).getDislikeCount());
                                intent.putExtra("izlenme",yeniHaberler.get(position).getWiewCount());
                                startActivity(intent);
                            }
                        });
                        Toast.makeText(MainActivity.this,newsList.toString(),Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    public void ekonomi(View view){
        yeniHaberler.clear();
        request.setType(NewsType.Ekonomi);
        Call<GetNewsResponse> verilerimilistele = apiService.verilerimilistele(request);
        verilerimilistele.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                if (response.isSuccessful()){
                    GetNewsResponse newsResponse = response.body();
                    List<News> newsList = newsResponse.getNewsList();
                    String [] ekonomii =new String[newsList.size()];
                    for(int i=0;i<newsList.size();i++){
                        ekonomii[i]=newsList.get(i).getTitle().toString();
                        yeniHaberler.add(newsList.get(i));

                    }
                    ArrayAdapter<String> ekonomiadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,ekonomii);
                    listView.setAdapter(ekonomiadapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(getApplicationContext(),Goster.class);
                            intent.putExtra("baslik",yeniHaberler.get(position).getTitle());
                            intent.putExtra("resim",yeniHaberler.get(position).getImage());
                            intent.putExtra("turu",yeniHaberler.get(position).getType());
                            intent.putExtra("icerik",yeniHaberler.get(position).getDescription());
                            intent.putExtra("tarihi",yeniHaberler.get(position).getPublishDate());
                            intent.putExtra("id",yeniHaberler.get(position).getId());
                            intent.putExtra("begenme",yeniHaberler.get(position).getLikeCount());
                            intent.putExtra("begenmeme",yeniHaberler.get(position).getDislikeCount());
                            intent.putExtra("izlenme",yeniHaberler.get(position).getWiewCount());
                            startActivity(intent);
                        }
                    });
                    Toast.makeText(MainActivity.this,newsList.toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void spor(View view){
        yeniHaberler.clear();
        request.setType(NewsType.Spor);
        Call<GetNewsResponse> verilerimilistele = apiService.verilerimilistele(request);
        verilerimilistele.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                if (response.isSuccessful()){
                    GetNewsResponse newsResponse = response.body();
                    List<News> newsList = newsResponse.getNewsList();
                    String [] sporr=new String[newsList.size()];
                    for(int i=0;i<newsList.size();i++){
                        sporr[i]=newsList.get(i).getTitle().toString();
                        yeniHaberler.add(newsList.get(i));

                    }
                    ArrayAdapter<String> sporadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,sporr);
                    listView.setAdapter(sporadapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(getApplicationContext(),Goster.class);
                            intent.putExtra("baslik",yeniHaberler.get(position).getTitle());
                            intent.putExtra("resim",yeniHaberler.get(position).getImage());
                            intent.putExtra("turu",yeniHaberler.get(position).getType());
                            intent.putExtra("icerik",yeniHaberler.get(position).getDescription());
                            intent.putExtra("tarihi",yeniHaberler.get(position).getPublishDate());
                            intent.putExtra("id",yeniHaberler.get(position).getId());
                            intent.putExtra("begenme",yeniHaberler.get(position).getLikeCount());
                            intent.putExtra("begenmeme",yeniHaberler.get(position).getDislikeCount());
                            intent.putExtra("izlenme",yeniHaberler.get(position).getWiewCount());
                            startActivity(intent);
                        }
                    });
                    Toast.makeText(MainActivity.this,newsList.toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void magazin(View view){
        yeniHaberler.clear();
        request.setType(NewsType.Magazin);
        Call<GetNewsResponse> verilerimilistele = apiService.verilerimilistele(request);
        verilerimilistele.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                if (response.isSuccessful()){
                    GetNewsResponse newsResponse = response.body();
                    List<News> newsList = newsResponse.getNewsList();
                    String [] magazinn=new String[newsList.size()];
                    for(int i=0;i<newsList.size();i++){
                        magazinn[i]=newsList.get(i).getTitle().toString();
                        yeniHaberler.add(newsList.get(i));

                    }
                    ArrayAdapter<String> magazinadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,magazinn);
                    listView.setAdapter(magazinadapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(getApplicationContext(),Goster.class);
                            intent.putExtra("baslik",yeniHaberler.get(position).getTitle());
                            intent.putExtra("resim",yeniHaberler.get(position).getImage());
                            intent.putExtra("turu",yeniHaberler.get(position).getType());
                            intent.putExtra("icerik",yeniHaberler.get(position).getDescription());
                            intent.putExtra("tarihi",yeniHaberler.get(position).getPublishDate());
                            intent.putExtra("id",yeniHaberler.get(position).getId());
                            intent.putExtra("begenme",yeniHaberler.get(position).getLikeCount());
                            intent.putExtra("begenmeme",yeniHaberler.get(position).getDislikeCount());
                            intent.putExtra("izlenme",yeniHaberler.get(position).getWiewCount());
                            startActivity(intent);
                        }
                    });
                    Toast.makeText(MainActivity.this,newsList.toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void sanat(View view){
        yeniHaberler.clear();
        request.setType(NewsType.Sanat);
        Call<GetNewsResponse> verilerimilistele = apiService.verilerimilistele(request);
        verilerimilistele.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                if (response.isSuccessful()){
                    GetNewsResponse newsResponse = response.body();
                    List<News> newsList = newsResponse.getNewsList();
                    String [] sanatt=new String[newsList.size()];
                    for(int i=0;i<newsList.size();i++){
                        sanatt[i]=newsList.get(i).getTitle().toString();
                        yeniHaberler.add(newsList.get(i));

                    }
                    ArrayAdapter<String> sanatadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,sanatt);
                    listView.setAdapter(sanatadapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(getApplicationContext(),Goster.class);
                            intent.putExtra("baslik",yeniHaberler.get(position).getTitle());
                            intent.putExtra("resim",yeniHaberler.get(position).getImage());
                            intent.putExtra("turu",yeniHaberler.get(position).getType());
                            intent.putExtra("icerik",yeniHaberler.get(position).getDescription());
                            intent.putExtra("tarihi",yeniHaberler.get(position).getPublishDate());
                            intent.putExtra("id",yeniHaberler.get(position).getId());
                            intent.putExtra("begenme",yeniHaberler.get(position).getLikeCount());
                            intent.putExtra("begenmeme",yeniHaberler.get(position).getDislikeCount());
                            intent.putExtra("izlenme",yeniHaberler.get(position).getWiewCount());
                            startActivity(intent);
                        }
                    });
                    Toast.makeText(MainActivity.this,newsList.toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Hata olustu",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Hata olustu"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
