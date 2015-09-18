package net.rafaeltoledo.materialchef;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private static final List<String> ITEMS = Arrays.asList("Marshmallow", "Lollipop", "KitKat",
            "JellyBean", "Ice Cream Sandwich", "Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake");

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.title.setText(ITEMS.get(position));
        holder.subtitle.setText(String.format("Item #%d", position));
    }

    @Override
    public int getItemCount() {
        return ITEMS.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView title, subtitle;

        public MainViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(android.R.id.text1);
            subtitle = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }
}
