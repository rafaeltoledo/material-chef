package net.rafaeltoledo.materialchef;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private static final List<String> ITEMS = Arrays.asList("Pretty Pasta", "Hmm... Dessert",
            "Pizza!", "Crispy Steak", "Barbecue Sauce");

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        if (context instanceof View.OnClickListener) {
            holder.itemView.setOnClickListener((View.OnClickListener) context);
        }

        String title = ITEMS.get(position % 5);
        int image = context.getResources().getIdentifier(String.format("img_0%d", (position % 5) + 1),
                "drawable", context.getPackageName());

        holder.itemView.setTag(R.id.title, title);
        holder.itemView.setTag(R.id.image, image);

        holder.title.setText(title);
        holder.image.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return ITEMS.size() * 10;
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public MainViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
