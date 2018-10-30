package com.example.mahfuz.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahfuz on 8/6/18.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList;

    ProductAdapter (Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_list_layout,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productPriceTv.setText(productList.get(position).getPrice()+"");
        holder.productNameTv.setText(productList.get(position).getName()+"");
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productNameTv;
        TextView productPriceTv;

        public ViewHolder(final View itemView) {
            super(itemView);

            productNameTv =itemView.findViewById(R.id.productNameTv);
            productPriceTv =itemView.findViewById(R.id.priceTv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent updateProductIntent = new Intent(itemView.getContext(), UpdateProductActivity.class);
                    Log.d("product Id:", productList.get(getAdapterPosition()).getId()+"");
                    updateProductIntent.putExtra("product", productList.get(getAdapterPosition()));
                    itemView.getContext().startActivity(updateProductIntent);
                }
            });
        }
    }
}
