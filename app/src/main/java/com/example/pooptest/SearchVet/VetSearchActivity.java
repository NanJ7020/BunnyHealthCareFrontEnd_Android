package com.example.pooptest.SearchVet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pooptest.HealthCare;
import com.example.pooptest.Models.BackEndRequest.YelpSearchRequest;
import com.example.pooptest.Models.BackEndResponse.YelpResponse;
import com.example.pooptest.Models.Yelp;
import com.example.pooptest.R;
import com.example.pooptest.Services.YelpSearchService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pooptest.AcctBaseActivity.profile;
import static com.example.pooptest.SearchVet.VetSearchBaseActivity.vetSearchResults;
import static com.example.pooptest.SearchVet.VetSearchBaseActivity.yelpSearchService;

public class VetSearchActivity extends AppCompatActivity {
    ListView listView;
    EditText et_location,et_term;
    VetItemAdapter adapter_vetItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_search);

        et_location=findViewById(R.id.location_EditText);
        et_term=findViewById(R.id.term_EitText);


        String location=profile.getZipcode();

        String term="vet";
        String categories="";
        String limit="";

        et_location.setText(location);
        et_term.setText("Vet");

        listView=findViewById(R.id.vets_listView);

        adapter_vetItem=new VetItemAdapter(getApplicationContext(),R.layout.list_view_vet_search_item,vetSearchResults);

        listView.setAdapter(adapter_vetItem);


        Call<YelpResponse> call=yelpSearchService.getSearchVets(new YelpSearchRequest(term,location,categories,limit));

        call.enqueue(new Callback<YelpResponse>() {
            @Override
            public void onResponse(Call<YelpResponse> call, Response<YelpResponse> response) {
                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Toast.makeText(getApplicationContext(),"No vet searched",Toast.LENGTH_SHORT).show();
                    }
                    Log.i("testSearch","failed");
                    return;
                }

                YelpResponse yelpResponse=response.body();
                Log.i("testSearch",""+yelpResponse.getYelp().size());



                vetSearchResults.clear();
                vetSearchResults.addAll(yelpResponse.getYelp());

                adapter_vetItem.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<YelpResponse> call, Throwable t) {
                Log.i("testSearch","failed");
            }
        });


    }

    //onclick function
    public void mainMenu(View view){
        Intent intent = new Intent(this, HealthCare.class);
        startActivity(intent);
    }

    public void detail (View view){
        Intent intent =  new Intent(this,VetDetailActivity.class);
        startActivity(intent);
    }

    public void search(View view){

        String location=et_location.getText().toString().trim();
        String term=et_term.getText().toString().trim();
        String categories="";
        String limit="";

        if (TextUtils.isEmpty(location)) {
            Toast.makeText(getApplicationContext(),"location is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(term)) {
            Toast.makeText(getApplicationContext(),"term is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        YelpSearchRequest yelpSearchRequest=new YelpSearchRequest(term,location,categories,limit);
        Call<YelpResponse> call=yelpSearchService.getSearchVets(yelpSearchRequest);

        call.enqueue(new Callback<YelpResponse>() {
            @Override
            public void onResponse(Call<YelpResponse> call, Response<YelpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Search vet failed",Toast.LENGTH_SHORT).show();
                    return;
                }

                YelpResponse yelpResponse=response.body();
                vetSearchResults.clear();
                vetSearchResults.addAll(yelpResponse.getYelp());

                adapter_vetItem.notifyDataSetChanged();
                Log.i("testSearch",""+yelpResponse.getYelp().size());
            }

            @Override
            public void onFailure(Call<YelpResponse> call, Throwable t) {

            }
        });

    }
}