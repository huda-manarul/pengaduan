package mana.huda.masukkan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import mana.huda.masukkan.R;
import mana.huda.masukkan.activity.DetailActivity;
import mana.huda.masukkan.model.SemuaPengaduan;

import static java.security.AccessController.getContext;

/**
 * Created by Huda Mana on 25-Jul-18.
 */
public class JajalAdapter extends RecyclerView.Adapter<JajalAdapter.VHolder> {

    JSONArray jsonArray;
    Context context;

    public JajalAdapter(JSONArray jsonArray,Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view,parent,false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        try {
            final JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.title.setText(jsonObject.getString("title"));
            holder.status.setText(jsonObject.getString("status"));
            holder.isu.setText(jsonObject.getString("issue"));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    try {
                        intent.putExtra("title",jsonObject.getString("title"));
                        intent.putExtra("status",jsonObject.getString("status"));
                        intent.putExtra("issue",jsonObject.getString("issue"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    context.startActivity(intent);

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class VHolder extends RecyclerView.ViewHolder {
        TextView title, status, isu;
        public VHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.tvTitle);
            status = (TextView)itemView.findViewById(R.id.tvStatus);
            isu = (TextView)itemView.findViewById(R.id.tvIssue);
        }
    }
}