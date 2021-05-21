package company.danhy.clothesuit.activity.activity.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import company.danhy.clothesuit.R;
import company.danhy.clothesuit.activity.activity.adapter.LoaispAdapter;
import company.danhy.clothesuit.activity.activity.adapter.SanphamAdapter;
import company.danhy.clothesuit.activity.activity.model.Loaisp;
import company.danhy.clothesuit.activity.activity.model.Sanpham;
import company.danhy.clothesuit.activity.activity.ultil.Server;
import company.danhy.clothesuit.activity.activity.ultil.checkconnect;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList <Loaisp> mangloaisanpham;
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    LoaispAdapter loaispAdapter;
    int id=0;
    String tenloaisanpham="";
    String hinhanhloaisanpham="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if(checkconnect.isNetworkAvailable(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            getDuLieuLoaiSanPham();
            getDuLieuSPMoiNhat();
            catOnItemListView();
        }else{
            checkconnect.ShowToast_Short(getApplicationContext(),"Bạn kiểm tra lại kết nối ");
            finish();
        }

    }

    private void catOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"Bạn kiểm tra lại kết nối!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
            }
        });
    }

    private void getDuLieuSPMoiNhat() {
        RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.duongDanSanPhamMoiNhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham = "";
                    String Motasanpham = "";
                    int IDsanpham = 0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject  =response.getJSONObject(i);
                            ID=jsonObject.getInt("id");
                            Tensanpham=jsonObject.getString("tensp");
                            Giasanpham=jsonObject.getInt("giasp");
                            Hinhanhsanpham=jsonObject.getString("hinhanhsp");
                            Motasanpham=jsonObject.getString("motasp");
                            IDsanpham=jsonObject.getInt("idsanpham");
                            mangsanpham.add(new Sanpham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham));
                            sanphamAdapter.notifyDataSetChanged();
                        }  catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }




    private void getDuLieuLoaiSanPham() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.duongDanLoaiSanPham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){

                    for(int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject =response.getJSONObject(i);
                            id =jsonObject.getInt("id");
                            Log.d("test", id+".......................");
                            tenloaisanpham=jsonObject.getString("tenloaisp");
                            Log.d("test", tenloaisanpham+".......................");
                            hinhanhloaisanpham =jsonObject.getString("hinhanhloaisanpham");
                            mangloaisanpham.add(new Loaisp(id,tenloaisanpham,hinhanhloaisanpham));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    Toast.makeText(getApplicationContext(), tenloaisanpham, Toast.LENGTH_SHORT).show();
                    mangloaisanpham.add( new Loaisp(0,"Liên hệ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpCeVuVWGdIbeB88vj6moAw0vSEt5dPuRFN0FZqy5UdS5wN1wp"));
                    mangloaisanpham.add(new Loaisp(2,"Thông tin","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSynBh4ywTCWrkfmGUUKvbhd7ahU-tm2iyTQPnLQixfOr7q-9QzKQ"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("test", error.getMessage());
                checkconnect.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private ArrayList<String> mangQuangCao(){
        ArrayList<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add(getString(R.string.anhQuangCao1));
        mangQuangCao.add(getString(R.string.anhQuangCao2));
        mangQuangCao.add(getString(R.string.anhQuangCao3));
        return mangQuangCao;
    }

    private void SetAnimationForViewFlipper(ViewFlipper viewFlipper){
        Animation slide_in_right = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        Animation slide_out_right = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
        viewFlipper.setOutAnimation(slide_out_right);
        viewFlipper.setInAnimation(slide_in_right);
    }

    private void ActionViewFlipper() {
        for(int i=0;i<this.mangQuangCao().size();i++){
            ImageView imageView = new ImageView(this);
            Picasso.get().load(this.mangQuangCao().get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(7000);
        viewFlipper.setAutoStart(true);
        this.SetAnimationForViewFlipper(viewFlipper);

    }


    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    void AnhXa(){
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper);
        recyclerViewmanhinhchinh = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationview);
        listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        mangloaisanpham =new ArrayList<>();
        mangloaisanpham.add(0,new Loaisp(0,"Trang chính","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyyPFbxER9CaziwnRh9UgBFqauaA2DOR_ZTCXFkK9iLmFdeoPE5w"));
        loaispAdapter=new LoaispAdapter(mangloaisanpham,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);
        mangsanpham=new ArrayList<>();
        sanphamAdapter =new SanphamAdapter(getApplicationContext(),mangsanpham);
        recyclerViewmanhinhchinh.setHasFixedSize(true);
        recyclerViewmanhinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewmanhinhchinh.setAdapter(sanphamAdapter);
    }
}
