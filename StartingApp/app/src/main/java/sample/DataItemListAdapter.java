package sample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.data.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.DataItem;

/**
 * Created by mislam on 7/2/17.
 */

public class DataItemListAdapter extends ArrayAdapter<DataItem> {

    List<DataItem> mDataItem;
    LayoutInflater mInflater;
    public DataItemListAdapter(Context context, List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        mDataItem = objects;
        mInflater =  LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item,parent,false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.itemNameText);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        DataItem item = mDataItem.get(position);
        tvName.setText(item.getItemName());
        String imageFile = item.getImage();
        InputStream stream = null;
        try {
            stream = getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(stream,null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream !=null){
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return convertView;
    }
}
