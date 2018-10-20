package com.mywings.lovesms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FirstListPage extends AppCompatActivity {

    String[] title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list_page);
        this.title = getResources().getStringArray(R.array.title_array);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                selectItem(position);
            }

            private void selectItem(int position) {
                Intent intent1 = new Intent(FirstListPage.this, MainActivity.class);
                intent1.putExtra("cat", position);
                intent1.putExtra("cat_name", FirstListPage.this.title[position]);
                FirstListPage.this.startActivity(intent1);
            }
        });



    }


    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<Item> items = new ArrayList();

        private class Item {
            final int drawableId;
            final String name;

            Item(String name, int drawableId) {
                this.name = name;
                this.drawableId = drawableId;
            }
        }

        public MyAdapter(Context context) {
            this.inflater = LayoutInflater.from(context);
            this.items.add(new Item(FirstListPage.this.getString(R.string.all), R.drawable.sarv));
            this.items.add(new Item(FirstListPage.this.getString(R.string.navin), R.drawable.prem));
            this.items.add(new Item(FirstListPage.this.getString(R.string.admin), R.drawable.maitri));
            this.items.add(new Item(FirstListPage.this.getString(R.string.vinodi), R.drawable.aathavan));
            this.items.add(new Item(FirstListPage.this.getString(R.string.maitri), R.drawable.jivalag));
            this.items.add(new Item(FirstListPage.this.getString(R.string.tomane), R.drawable.bhavna));
            this.items.add(new Item(FirstListPage.this.getString(R.string.gfbf), R.drawable.virah));
            this.items.add(new Item(FirstListPage.this.getString(R.string.navarabaiko), R.drawable.valentine));
            this.items.add(new Item(FirstListPage.this.getString(R.string.teacher), R.drawable.vinodi));
            this.items.add(new Item(FirstListPage.this.getString(R.string.bollywood), R.drawable.kavita));
            this.items.add(new Item(FirstListPage.this.getString(R.string.mitra), R.drawable.premvichar));
            this.items.add(new Item(FirstListPage.this.getString(R.string.puneri), R.drawable.tuaanime));
            this.items.add(new Item(FirstListPage.this.getString(R.string.lagn), R.drawable.filmy));
            this.items.add(new Item(FirstListPage.this.getString(R.string.kavita), R.drawable.lagn));
            this.items.add(new Item(FirstListPage.this.getString(R.string.malvani), R.drawable.paus));
            this.items.add(new Item(FirstListPage.this.getString(R.string.social), R.drawable.gulabithandi));
            this.items.add(new Item(FirstListPage.this.getString(R.string.social), R.drawable.shayri));
            this.items.add(new Item(FirstListPage.this.getString(R.string.social), R.drawable.charoli));
        }

        public int getCount() {
            return this.items.size();
        }

        public Object getItem(int i) {
            return this.items.get(i);
        }

        public long getItemId(int i) {
            return (long) ((Item) this.items.get(i)).drawableId;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            if (v == null) {
                v = this.inflater.inflate(R.layout.gridview_items, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }
            TextView nm = (TextView) v.getTag(R.id.text);
            Item item = (Item) getItem(i);
            ((ImageView) v.getTag(R.id.picture)).setImageResource(item.drawableId);
            nm.setText(item.name);
            return v;
        }
    }


}
