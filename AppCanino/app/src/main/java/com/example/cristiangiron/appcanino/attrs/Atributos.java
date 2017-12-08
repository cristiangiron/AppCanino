package com.example.cristiangiron.appcanino.attrs;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by CristianGiron on 22/05/2017.
 */

public class  Atributos {

    @BindingAdapter("app:imgUrl")
    public static void setImage(ImageView img, String url){
        Picasso.with(img.getContext())
                .load(Uri.parse(url))
                .into(img);


    }
}
