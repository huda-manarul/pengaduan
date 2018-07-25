//package mana.huda.masukkan.adapter;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.amulyakhare.textdrawable.TextDrawable;
//import mana.huda.masukkan.R;
//import mana.huda.masukkan.model.SemuaPengaduan;
//
//import java.util.List;
//import java.util.Random;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
///**
// * Created by Huda Mana on 22-Jul-18.
// */
//
//public class PengaduanAdapter extends RecyclerView.Adapter<PengaduanAdapter.PengaduanHolder> {
//    Context mContext;
//    List<SemuaPengaduan> semuaMasukanItemList;
//
//    public String[] mColors = {
//            "#39add1", // light blue
//            "#3079ab", // dark blue
//            "#c25975", // mauve
//            "#e15258", // red
//            "#f9845b", // orange
//            "#838cc7", // lavender
//            "#7d669e", // purple
//            "#53bbb4", // aqua
//            "#51b46d", // green
//            "#e0ab18", // mustard
//            "#637a91", // dark gray
//            "#f092b0", // pink
//            "#b7c0c7"  // light gray
//    };
//
//    public PengaduanAdapter(Context context, List<SemuaPengaduan> pengaduanList) {
//        this.mContext = context;
//        SemuaPengaduan = pengaduanList;
//    }
//
//    @Override
//    public PengaduanAdapter.PengaduanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
//        return new PengaduanHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(PengaduanAdapter.PengaduanHolder holder, int position) {
//        final SemuaPengaduan semuaMasukanItem = semuaMasukanItemList.get(position);
//        holder.tvTitle.setText(semuaMasukanItem.getJudul_pengaduan());
//        holder.tvIssue.setText(semuaMasukanItem.getIsi_pengaduan());
//        holder.tvStatus.setText(semuaMasukanItem.getStatus_pengaduan());
//
//        String judul = semuaMasukanItem.getJudul_pengaduan();
//        String firstCharJudul = judul.substring(0,1);
//        TextDrawable drawable = TextDrawable.builder()
//                .buildRound(firstCharJudul, getColor());
//        holder.ivTextDrawable.setImageDrawable(drawable);
//    }
//
//    @Override
//    public int getItemCount() {
//        return semuaMasukanItemList.size();
//    }
//
//    public class PengaduanHolder extends RecyclerView.ViewHolder{
//
//        @BindView(R.id.ivTextDrawable)
//        ImageView ivTextDrawable;
//        @BindView(R.id.tvTitle)
//        TextView tvTitle;
//        @BindView(R.id.tvIssue)
//        TextView tvIssue;
//        @BindView(R.id.tvStatus)
//        TextView tvStatus;
//
//        public PengaduanHolder(View itemView) {
//            super(itemView);
//
//            ButterKnife.bind(this, itemView);
//        }
//    }
//
//    public int getColor() {
//        String color;
//
//        // Randomly select a fact
//        Random randomGenerator = new Random(); // Construct a new Random number generator
//        int randomNumber = randomGenerator.nextInt(mColors.length);
//
//        color = mColors[randomNumber];
//        int colorAsInt = Color.parseColor(color);
//
//        return colorAsInt;
//    }
//}
