package com.example.smartpantry.ui.pantry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantry.R;
import com.example.smartpantry.model.PantryItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Custom RecyclerView.Adapter that binds pantry items to item_pantry.xml.
 * Exposes click and delete callbacks so the Fragment stays in control.
 */
public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.VH> {

    // Colour-code each item by how close it is to expiring, so the user can
    // see at a glance what to use first. Grey = no date, green = fresh,
    // orange = expiring within 3 days, red = already expired.
    private static final int COLOR_NONE    = 0xFF9E9E9E; // grey  - no expiry set
    private static final int COLOR_FRESH   = 0xFF28B463; // green - plenty of time
    private static final int COLOR_SOON    = 0xFFE67E22; // orange- 3 days or less
    private static final int COLOR_EXPIRED = 0xFFC0392B; // red   - past its date

    // Returns how many whole days from today until the given date
    // (negative = already in the past). Returns null if the date is
    // missing or cannot be read.
    private static Long daysUntil(String expiry) {
        if (expiry == null || expiry.trim().isEmpty()) return null;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            fmt.setLenient(false);
            Date exp = fmt.parse(expiry.trim());
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            long diffMs = exp.getTime() - today.getTimeInMillis();
            return diffMs / (1000L * 60 * 60 * 24);
        } catch (Exception e) {
            return null;
        }
    }

    private static int colorForExpiry(String expiry) {
        Long days = daysUntil(expiry);
        if (days == null) return COLOR_NONE;
        if (days < 0) return COLOR_EXPIRED;
        if (days <= 3) return COLOR_SOON;
        return COLOR_FRESH;
    }

    public interface Listener {
        void onEdit(PantryItem item);
        void onDelete(PantryItem item);
    }

    private final List<PantryItem> items = new ArrayList<>();
    private final Listener listener;

    public PantryAdapter(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<PantryItem> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        PantryItem item = items.get(position);
        h.name.setText(item.getName());

        // Colour-code this row by how close the item is to expiring.
        int color = colorForExpiry(item.getExpiryDate());
        h.colorBar.setBackgroundColor(color);

        String qty = trimNumber(item.getQuantity()) + " " +
                (item.getUnit() == null ? "" : item.getUnit());
        h.qty.setText(qty.trim());

        String expiry = item.getExpiryDate();
        if (expiry != null && !expiry.isEmpty()) {
            h.expiry.setVisibility(View.VISIBLE);
            Long days = daysUntil(expiry);
            String label;
            if (days == null) {
                label = "Expires: " + expiry;
            } else if (days < 0) {
                label = "Expired (" + expiry + ")";
            } else if (days == 0) {
                label = "Expires today (" + expiry + ")";
            } else if (days <= 3) {
                label = "Expiring soon: " + expiry;
            } else {
                label = "Expires: " + expiry;
            }
            h.expiry.setText(label);
            h.expiry.setTextColor(color);
        } else {
            h.expiry.setVisibility(View.GONE);
        }

        h.itemView.setOnClickListener(v -> listener.onEdit(item));
        h.delete.setOnClickListener(v -> listener.onDelete(item));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private String trimNumber(double d) {
        if (d == Math.floor(d)) return String.valueOf((long) d);
        return String.valueOf(d);
    }

    static class VH extends RecyclerView.ViewHolder {
        final TextView name, qty, expiry;
        final View delete, colorBar;

        VH(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.item_name);
            qty = v.findViewById(R.id.item_qty);
            expiry = v.findViewById(R.id.item_expiry);
            delete = v.findViewById(R.id.item_delete);
            colorBar = v.findViewById(R.id.item_color_bar);
        }
    }
}
