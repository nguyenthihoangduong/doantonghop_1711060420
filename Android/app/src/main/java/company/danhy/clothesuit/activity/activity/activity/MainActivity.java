package company.danhy.clothesuit.activity.activity.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import company.danhy.clothesuit.activity.activity.adapter.SanPhamFlashSaleAdapter;
import company.danhy.clothesuit.activity.activity.adapter.SanphamAdapter;
import company.danhy.clothesuit.activity.activity.model.Giohang;
import company.danhy.clothesuit.activity.activity.model.Loaisp;
import company.danhy.clothesuit.activity.activity.model.Sanpham;
import company.danhy.clothesuit.activity.activity.ultil.Server;
import company.danhy.clothesuit.activity.activity.ultil.checkconnect;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh,recyclerViewflashSaleItems;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList <Loaisp> mangloaisanpham;
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    ArrayList<Sanpham> mangSanPhamFlashSale;
    SanPhamFlashSaleAdapter sanPhamFlashSaleAdapter;
    LoaispAdapter loaispAdapter;
    int id=0;
    String tenloaisanpham="";
    String hinhanhloaisanpham="";
//    UserLocalStore userLocalStore;
    public static ArrayList<Giohang>manggiohang;


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
            getDuLieuSPFlashSale();
        }else{
            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i ");
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        User user = userLocalStore.getLoggedInUser();
        switch(item.getItemId()){
            case R.id.menugiohang:
                Intent intent=new Intent(getApplicationContext(), GiohangActivity.class);
                startActivity(intent);
//                break;
//            case R.id.menuLogout:
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Logout");
//                builder.setMessage("Username : "+user.username+"\nEmail :"+ user.email);
//                builder.setCancelable(false);
//                builder.setPositiveButton("Tr??? v???", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this, "M???i b???n ti???p t???c mua s???m", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("Logout", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //Code Logout
//                        userLocalStore.clearUserData();
//                        userLocalStore.setUserLoggedIn(false);
//                        Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
//                        startActivity(loginIntent);
//                        Toast.makeText(MainActivity.this, "????ng xu???t th??nh c??ng", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//                break;
        }
        return super.onOptionsItemSelected(item);
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
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,GioiThieuActivity.class);
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,ThoiTrangActivity.class);
                            intent.putExtra("idLoaiSanPham",mangloaisanpham.get(position).getId());
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,DungCuHangNgayActivity.class);
                            intent.putExtra("idLoaiSanPham",mangloaisanpham.get(position).getId());
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,ThucAnActivity.class);
                            intent.putExtra("idLoaiSanPham",mangloaisanpham.get(position).getId());
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,SucKhoeActivity.class);
                            intent.putExtra("idLoaiSanPham",mangloaisanpham.get(position).getId());
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,DichvuActivity.class);
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 7:
                        if(checkconnect.isNetworkAvailable(getApplicationContext())){
                            Intent intent =new Intent(MainActivity.this,LienHeActivity.class);
                            startActivity(intent);
                        }else{
                            checkconnect.ShowToast_Short(getApplicationContext(),"B???n ki???m tra l???i k???t n???i!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }
            }
        });
    }

    private void getDuLieuSPFlashSale() {
        RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.duongDanflashsale, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    String Tensanphamsale = "";
                    Integer Giasanphamsale = 0;
                    String Hinhanhsanphamsale = "";
                    String Motasanphamsale = "";
                    int IDsanphamsale = 0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject  =response.getJSONObject(i);
                            ID=jsonObject.getInt("id");
                            Tensanphamsale=jsonObject.getString("tensp");
                            Giasanphamsale=jsonObject.getInt("giasp");
                            Hinhanhsanphamsale=jsonObject.getString("hinhanhsp");
                            Motasanphamsale=jsonObject.getString("motasp");
                            IDsanphamsale=jsonObject.getInt("idsanpham");
                            mangSanPhamFlashSale.add(new Sanpham(ID,Tensanphamsale,Giasanphamsale,Hinhanhsanphamsale,Motasanphamsale,IDsanphamsale));
                            sanPhamFlashSaleAdapter.notifyDataSetChanged();
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
                    mangloaisanpham.add(new Loaisp(2,"Gi???i Thi???u","https://image.flaticon.com/icons/png/128/1808/1808939.png"));

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
                    mangloaisanpham.add( new Loaisp(0,"D???ch v???","https://thumbs.dreamstime.com/b/illustration-emblem-dog-hair-salon-haircut-grooming-shop-illustration-emblem-dog-hair-salon-haircut-grooming-shop-168214154.jpg"));
                    mangloaisanpham.add(new Loaisp(2,"Li??n h???","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpCeVuVWGdIbeB88vj6moAw0vSEt5dPuRFN0FZqy5UdS5wN1wp"));

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

        recyclerViewflashSaleItems = findViewById(R.id.recyclerViewHotItems);

        mangloaisanpham =new ArrayList<>();
        mangloaisanpham.add(0,new Loaisp(0,"Trang ch??nh","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyyPFbxER9CaziwnRh9UgBFqauaA2DOR_ZTCXFkK9iLmFdeoPE5w"));

        loaispAdapter=new LoaispAdapter(mangloaisanpham,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);

        mangsanpham=new ArrayList<>();
        sanphamAdapter =new SanphamAdapter(getApplicationContext(),mangsanpham);

        mangSanPhamFlashSale=new ArrayList<>();
        sanPhamFlashSaleAdapter = new SanPhamFlashSaleAdapter(getApplicationContext(),mangSanPhamFlashSale);

        recyclerViewmanhinhchinh.setHasFixedSize(true);
        recyclerViewmanhinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewmanhinhchinh.setAdapter(sanphamAdapter);

        recyclerViewflashSaleItems.setHasFixedSize(true);
        recyclerViewflashSaleItems.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewflashSaleItems.setAdapter(sanPhamFlashSaleAdapter);

        if(manggiohang!=null){

        }else{
            manggiohang=new ArrayList<>();
        }
    }
}
